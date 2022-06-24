package org.sid.secservice.sec.repo;


import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Inscription;
import org.sid.secservice.sec.entities.Niveau;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Inscription entity.
 */

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

	Inscription findByGroupeAndEtudiantIneAndAnneeAccademiqueActifTrue(Groupe groupe, String ine );
	List<Inscription> findByGroupeNiveauAndEtudiantIneOrderByAnneeAccademiqueNomAnneeAccademiqueAsc(Niveau niveau,String ine);


	/* List<Inscription> findByAppUser(AppUser appUser); */

/* 	List<Inscription> findByGroupeAndAnneeAccademiqueOrderByEtudiantNomAscEtudiantPrenomAsc(Groupe groupe,AnneeAccademique anneeaccademique);

	List<Inscription> findByGroupeNiveauAndAnneeAccademiqueOrderByEtudiantNomAsc(Niveau niveau,	AnneeAccademique anneeAccademique);
	List<Inscription> findByGroupeNiveauAndEtatAndAnneeAccademiqueOrderByEtudiantNomAsc(Niveau niveau,EnumEtat enumEtat	,AnneeAccademique anneeAccademique);
	List<Inscription> findByGroupeNiveauFormationAndAnneeAccademiqueOrderByEtudiantNomAsc(Formation formation,AnneeAccademique anneeAccademique);
	List<Inscription> findByGroupeNiveauFormationAndAnneeAccademiqueAndEtat(Formation formation,AnneeAccademique anneeAccademique,EnumEtat enumEtat);
	@Query( "select  inscription from Inscription inscription where inscription.groupe.niveau.terminal='true' and (inscription.groupe.niveau.formation.typeEvaluatiion.typeEval=:typeEval1 or inscription.groupe.niveau.formation.typeEvaluatiion.typeEval=:typeEval2  ) and inscription.groupe.niveau.formation.departement=:departement and inscription.anneeAccademique=:anneeAccademique")
	List<Inscription> findByGroupeNiveauTerminalAndAnneeAccademiqueAndGroupeNiveauFormationDepartementOrderByEtudiantNomAsc(@Param("typeEval1") EnumTypeEvaluation typeEval1,@Param("typeEval2") EnumTypeEvaluation typeEval2 ,@Param("anneeAccademique") AnneeAccademique anneeAccademique ,@Param("departement") Structure structure);
	List<Inscription> findByGroupeNiveauAndAnneeAccademiqueAndEtat(Niveau niveau,AnneeAccademique anneeAccademique,EnumEtat enumEtat);

	List<Inscription> findByGroupeNiveauFormationDepartementAndAnneeAccademiqueOrderByEtudiantNomAsc(Structure structure, AnneeAccademique anneeAccademique);
	List<Inscription> findByGroupeNiveauFormationDepartement(Structure structure);
	List<Inscription> findByAnneeAccademiqueOrderByEtudiantNomAsc(AnneeAccademique anneeAccademique);
	@Query( "select  inscription from Inscription inscription where (inscription.etudiant=:etudiant  and inscription.groupe.niveau=:niveau and inscription.anneeAccademique.nomAnneeAccademique<=:nomAnneeAccademique  )   order by inscription.anneeAccademique.nomAnneeAccademique desc")
	List<Inscription> findByEtudiantAndGroupeNiveauOrderByAnneeAccademiqueNomAnneeAccademiqueDesc( @Param("etudiant") AppUser appUser,@Param("niveau") Niveau niveau,@Param("nomAnneeAccademique") String nomAnneeAccademique);

	Page<Inscription> findByGroupeAndAnneeAccademiqueOrderByEtudiantNomAscEtudiantPrenomAsc(Groupe groupe,AnneeAccademique anneeaccademique, Pageable pageable);

	Page<Inscription> findByGroupeAndAnneeAccademique(Groupe groupe, AnneeAccademique anneeAccademique,Pageable pageable);

	List<Inscription> findByGroupeAndAnneeAccademique(Groupe groupe, AnneeAccademique anneeAccademique);

    List<Inscription> findByGroupeNiveauAndAnneeAccademique(Niveau niveau, AnneeAccademique anneeAccademique);
	List<Inscription> findByGroupeNiveauFormationAndAnneeAccademique(Formation formation, AnneeAccademique anneeAccademique);
	Inscription findByGroupeAndAnneeAccademiqueAndEtudiant(Groupe groupe, AnneeAccademique anneeAccademique,AppUser appUser);

	Inscription findByGroupeNiveauFormationAndAnneeAccademiqueAndEtudiant(Formation formation,AnneeAccademique anneeAccademique, AppUser appUser);

	Inscription findByGroupeNiveauAndAnneeAccademiqueAndEtudiant(Niveau niveau, AnneeAccademique anneeAccademique,AppUser appUser);

	Inscription findByGroupeAndEtudiantAndAnneeAccademique(Groupe groupe, AppUser appUser,AnneeAccademique anneeAccademique);

	List<Inscription> findByGroupeAndEtatAndAnneeAccademique(Groupe groupe, EnumEtat ABANDON,AnneeAccademique anneeAccademique);
	List<Inscription> findByEtatAndAnneeAccademique(EnumEtat ABANDON,AnneeAccademique anneeAccademique);
	List<Inscription> findByEtat(EnumEtat ABANDON);
	List<Inscription> findByEtatAndGroupeNiveauFormationDepartement(EnumEtat ABANDON,Structure structure);
	@Query( "select  inscription from Inscription inscription where (inscription.etat<>'ABADON'  and inscription.etat<>'ENMOBILITE ' and inscription.etat<>'SUSPENSION'  ) and inscription.groupe=:groupe and inscription.anneeAccademique=:anneeAccademique  order by inscription.etudiant.nom , inscription.etudiant.prenom")
	List<Inscription> findByInscriptionAnneAcademique(@Param("groupe") Groupe groupe,@Param("anneeAccademique") AnneeAccademique anneeAccademique);

	List<Inscription> findByEtudiantAndAnneeAccademiqueOrderByGroupeNiveauNivLMDDesc(AppUser appUser,AnneeAccademique anneeAccademique);

	Inscription findByAnneeAccademiqueAndEtudiantAndCertificatFalse(AnneeAccademique anneeAccademique,AppUser appUser);
	List<Inscription> findAllByOrderByEtudiantNomAscEtudiantPrenomAsc(); */
	/* Inscription findByAnneeAccademiqueActifTrueAndEtudiantAndCertificatFalse(AppUser appUser); */
	@Query( "select  distinct inscription.groupe from Inscription inscription where inscription.etudiant.ine=:ine and inscription.anneeAccademique.actif='true'")
	List<Groupe> findByEtudiantIneAndAnneeAccademiqueActifTrue(@Param("ine") String ine);
}
