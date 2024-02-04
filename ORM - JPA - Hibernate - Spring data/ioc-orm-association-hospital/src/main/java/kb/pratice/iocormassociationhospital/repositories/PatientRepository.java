package kb.pratice.iocormassociationhospital.repositories;

import kb.pratice.iocormassociationhospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByNom(String name);
}
