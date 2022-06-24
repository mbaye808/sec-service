package org.sid.secservice.sec.web;

import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.repo.InscriptionRepository;
import org.sid.secservice.sec.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;


/**
 * REST controller for managing {@link sn.esp.pgi.domain.Inscription}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class InscriptionResource {

   /*  private final Logger log = LoggerFactory.getLogger(InscriptionResource.class);

    private static final String ENTITY_NAME = "inscription"; */

    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @GetMapping("/inscriptions/findByGroupeAndAnneeAcademique")
    public List<Groupe> getInscriptionByGroupeAndAnneeAcademique() {
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        return inscriptionRepository.findByEtudiantIneAndAnneeAccademiqueActifTrue(appUser.get().getIne());
    }
}
