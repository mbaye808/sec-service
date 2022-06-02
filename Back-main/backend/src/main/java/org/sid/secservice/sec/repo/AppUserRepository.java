package org.sid.secservice.sec.repo;

import org.sid.secservice.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	// méthode permettant de retourner le Username
	
	AppUser findByUsername(String username);

	AppUser findByIne(String idf);

    AppUser findByEmail(String email);
	

}
