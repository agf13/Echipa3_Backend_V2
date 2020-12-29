package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface IRepoCourse extends CrudRepository<Course, Long> {
}
