package com.lucaslearning.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.dslearnbds.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
