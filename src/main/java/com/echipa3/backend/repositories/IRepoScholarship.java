package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Scholarship;
import org.springframework.data.repository.CrudRepository;

public interface IRepoScholarship extends CrudRepository<Scholarship, Long> {
}
