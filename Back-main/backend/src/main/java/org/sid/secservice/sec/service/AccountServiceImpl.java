package org.sid.secservice.sec.service;

import java.util.List;

import javax.validation.Valid;

import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.repo.AppRoleRepository;
import org.sid.secservice.sec.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public AppUser addNewUser(AppUser appUser) {
		
		return appUserRepository.save(appUser);
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		
		return appRoleRepository.save(appRole);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		
		AppUser appUser = appUserRepository.findByUsername(username);
		AppRole appRole = appRoleRepository.findByRoleName(roleName);
		
		appUser.getAppRoles().add(appRole);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		
		
		return appUserRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> listUsers() {
		
		return appUserRepository.findAll();
	}

	@Override
	public AppUser fetchAppUserByIne(String idf) {

		return appUserRepository.findByIne(idf);
	}

	@Override
	public AppUser saveUser(@Valid AppUser appUser) {
		String pwd=appUser.getPassword();
		appUser.setPassword(passwordEncoder.encode(pwd));
		return appUserRepository.save(appUser);
	}

	@Override
	public AppUser fetchAppUserByEmail(String email) {
		
		return appUserRepository.findByEmail(email);
	}
	

}
