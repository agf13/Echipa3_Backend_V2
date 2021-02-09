package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepoUser extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
