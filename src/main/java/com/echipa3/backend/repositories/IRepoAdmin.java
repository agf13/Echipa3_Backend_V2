package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface IRepoAdmin extends CrudRepository<Admin, Long> {
}
