package com.lucaslearning.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.dslearnbds.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
