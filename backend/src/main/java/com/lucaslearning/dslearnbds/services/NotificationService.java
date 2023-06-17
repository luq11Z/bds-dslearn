package com.lucaslearning.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucaslearning.dslearnbds.dto.NotificationDTO;
import com.lucaslearning.dslearnbds.entities.Notification;
import com.lucaslearning.dslearnbds.entities.User;
import com.lucaslearning.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable) {
		User user = authService.authenticated();
		Page<Notification> page = repository.find(user, false, pageable);
		
		return page.map(x -> new NotificationDTO(x));
	}
	
}
