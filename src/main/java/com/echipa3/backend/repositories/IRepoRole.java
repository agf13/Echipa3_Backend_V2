package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepoRole extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
