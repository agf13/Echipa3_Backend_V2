package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Tag;
import org.springframework.data.repository.CrudRepository;

public interface IRepoTag extends CrudRepository<Tag, Long> {
}
