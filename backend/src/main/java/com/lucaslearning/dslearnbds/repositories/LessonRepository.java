package com.lucaslearning.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaslearning.dslearnbds.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
