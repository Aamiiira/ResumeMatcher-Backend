package com.ResumeMatcher.space.services;

import org.springframework.stereotype.Service;

import com.ResumeMatcher.space.dto.RegisterRequest;
import com.ResumeMatcher.space.entities.UserInformation;
import com.ResumeMatcher.space.repositories.UtilisateurRepo;

@Service
public class AuthService {
	
	private UtilisateurRepo userRepo ; 
	
	public void signup (RegisterRequest registerRequest) {
		UserInformation user = new UserInformation();
		user.setNom(registerRequest.getUserName());
		user.setPassword(registerRequest.getPassword());
		user.setEmail(registerRequest.getEmail());
		userRepo.save(user);
	}
	
}
