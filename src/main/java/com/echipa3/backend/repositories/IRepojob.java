package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Job;
import org.springframework.data.repository.CrudRepository;

public interface IRepojob extends CrudRepository<Job, Long> {
}
