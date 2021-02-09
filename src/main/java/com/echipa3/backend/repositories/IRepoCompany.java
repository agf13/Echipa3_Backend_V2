package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface IRepoCompany extends CrudRepository<Company, Long> {
}
