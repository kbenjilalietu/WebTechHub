package kb.pratice.iocormassociationhospital.repositories;

import kb.pratice.iocormassociationhospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
