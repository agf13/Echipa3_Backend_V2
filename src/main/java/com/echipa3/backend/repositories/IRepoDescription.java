package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Description;
import org.springframework.data.repository.CrudRepository;

public interface IRepoDescription extends CrudRepository<Description, Long> {
}
