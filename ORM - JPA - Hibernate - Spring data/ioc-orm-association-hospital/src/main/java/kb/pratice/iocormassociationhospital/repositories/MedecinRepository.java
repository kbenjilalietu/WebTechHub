package kb.pratice.iocormassociationhospital.repositories;

import kb.pratice.iocormassociationhospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
