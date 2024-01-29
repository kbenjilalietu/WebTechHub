package kb.practice.iocormspringdatajpa;

import kb.practice.iocormspringdatajpa.entities.Patient;
import kb.practice.iocormspringdatajpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for(int i=0; i<100; i++)
        {
            patientRepository.save(
                    new Patient(null, "name"+i, new Date(), Math.random()>0.5?false:true, (int)(Math.random()*100)));
        }

        System.out.println("=======================================");

        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0, 10));
        System.out.println("Total Pages : "+ patients.getTotalPages());
        System.out.println("Total Elements : "+ patients.getTotalElements());
        System.out.println("Num Page : "+ patients.getNumber());

        List<Patient> content = patients.getContent();

        Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0,4));

        List<Patient> patientList = patientRepository.cherchePatients("%1%", 40);



        patientList.forEach(p-> {
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println("----------------------------------------");
        });

        //Patient patient = patientRepository.findById(1L).orElseThrow(()-> new RuntimeException("Patient not found"));
        //System.out.println(patient.toString());

        //patientRepository.delete(patient);
    }
}
