package kb.pratice.iocormassociationhospital;

import kb.pratice.iocormassociationhospital.entities.*;
import kb.pratice.iocormassociationhospital.repositories.ConsultationRepository;
import kb.pratice.iocormassociationhospital.repositories.MedecinRepository;
import kb.pratice.iocormassociationhospital.repositories.PatientRepository;
import kb.pratice.iocormassociationhospital.repositories.RendezVousRepository;
import kb.pratice.iocormassociationhospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class IocOrmAssociationHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocOrmAssociationHospitalApplication.class, args);
    }
    @Bean // methode sui va exécuter au démarage et il va returner un objet
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository) {

        return args -> {
            // Create Medecins
            Stream.of("Mohamed", "Hassan", "Najat").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });

            // Create Patients
            Stream.of("Ayman", "Hanane", "Yasmine").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(medecin);

            });

            // Create un Rendez-Vous d'un Patient pour un Medcin
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin =  medecinRepository.findByNom("Yasmine");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRendezVous(rendezVous);

            // Create Consultation d'un rendezVous
            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Consultation N° : 1");
            hospitalService.saveConsultation(consultation);

        };

    }

}
