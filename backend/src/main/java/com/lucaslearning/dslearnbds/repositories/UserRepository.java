package com.lucaslearning.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.dslearnbds.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
