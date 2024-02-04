package kb.pratice.iocormassociationhospital.service;

import kb.pratice.iocormassociationhospital.entities.Consultation;
import kb.pratice.iocormassociationhospital.entities.Medecin;
import kb.pratice.iocormassociationhospital.entities.Patient;
import kb.pratice.iocormassociationhospital.entities.RendezVous;
import kb.pratice.iocormassociationhospital.repositories.ConsultationRepository;
import kb.pratice.iocormassociationhospital.repositories.MedecinRepository;
import kb.pratice.iocormassociationhospital.repositories.PatientRepository;
import kb.pratice.iocormassociationhospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
