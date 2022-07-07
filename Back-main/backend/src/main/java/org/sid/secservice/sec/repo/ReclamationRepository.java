package org.sid.secservice.sec.repo;

import java.util.List;

import org.sid.secservice.sec.entities.Reclamation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Reclamation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    List<Reclamation> findByAnneeAccademiqueActifTrueAndIne(String ine);
}
