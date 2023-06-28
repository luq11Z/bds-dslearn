package com.lucaslearning.dslearnbds.services;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaslearning.dslearnbds.dto.DeliverRevisionDTO;
import com.lucaslearning.dslearnbds.entities.Deliver;
import com.lucaslearning.dslearnbds.observers.DeliverRevisionObserver;
import com.lucaslearning.dslearnbds.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository repository;
	
	private Set<DeliverRevisionObserver> deliverRevisionObservers = new LinkedHashSet<>();
	
	@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDTO dto) {
		Deliver deliver = repository.getOne(id);
		
		deliver.setStatus(dto.getStatus());
		deliver.setFeedback(dto.getFeedback());
		deliver.setCorrectCount(dto.getCorrectCount());
		
		repository.save(deliver);
		
		for (DeliverRevisionObserver observer : deliverRevisionObservers) {
			observer.onSaveRevision(deliver);
		}
	}
	
	public void subscribedeliverRevisionObserver(DeliverRevisionObserver observer) {
		deliverRevisionObservers.add(observer);
	}
}
