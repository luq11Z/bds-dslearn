package com.lucaslearning.dslearnbds.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaslearning.dslearnbds.entities.User;
import com.lucaslearning.dslearnbds.repositories.UserRepository;
import com.lucaslearning.dslearnbds.services.exceptions.ForbiddenExcpetion;
import com.lucaslearning.dslearnbds.services.exceptions.UnauthorizedExcpetion;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();

			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedExcpetion("Invalid user");
		}
	}
	
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		
		if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenExcpetion("Access denied");
		}
	}

}
