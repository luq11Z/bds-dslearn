package com.lucaslearning.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.dslearnbds.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
