package com.lucaslearning.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.dslearnbds.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
