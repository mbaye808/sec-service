package org.sid.secservice.sec.web;

import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Reclamation;
import org.sid.secservice.sec.repo.AnneeAccademiqueRepository;
import org.sid.secservice.sec.repo.ReclamationRepository;
import org.sid.secservice.sec.service.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.time.Instant;

/**
 * REST controller for managing {@link sn.esp.pgi.domain.Reclamation}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ReclamationResource {

    private final Logger log = LoggerFactory.getLogger(ReclamationResource.class);

    private static final String ENTITY_NAME = "reclamation";

    @Autowired
    private AnneeAccademiqueRepository anneeAccademiqueRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    private final ReclamationRepository reclamationRepository;

    public ReclamationResource(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    @PostMapping("/reclamations")
    public Reclamation createReclamation(@RequestBody Reclamation reclamation){
        log.debug("REST request to save Reclamation : {}", reclamation);
        reclamation.setAnneeAccademique(anneeAccademiqueRepository.findByActifTrue());
        reclamation.setDate(Instant.now());
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        reclamation.setIne(appUser.get().getIne());
        Reclamation result = reclamationRepository.save(reclamation);
        return result;
    }

    @GetMapping("/reclamations")
    public List<Reclamation> getAllReclamations() {
        log.debug("REST request to get a page of Reclamations");
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        return reclamationRepository.findByAnneeAccademiqueActifTrueAndIne(appUser.get().getIne());       
    }
}
