package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Contest;
import org.springframework.data.repository.CrudRepository;

public interface IRepoContest extends CrudRepository<Contest, Long> {
}
