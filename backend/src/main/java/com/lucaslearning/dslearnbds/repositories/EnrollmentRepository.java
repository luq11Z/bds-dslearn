package com.lucaslearning.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.dslearnbds.entities.Enrollment;
import com.lucaslearning.dslearnbds.entities.pk.EnrollmentPK;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {

}
