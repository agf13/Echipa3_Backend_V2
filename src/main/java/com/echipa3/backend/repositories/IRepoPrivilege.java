package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepoPrivilege extends JpaRepository<Privilege, Long> {
    Privilege findByPrivilege(String privilege);
}
