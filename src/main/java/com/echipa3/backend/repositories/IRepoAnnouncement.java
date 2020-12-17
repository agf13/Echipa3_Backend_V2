package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Announcement;
import org.springframework.data.repository.CrudRepository;

public interface IRepoAnnouncement extends CrudRepository<Announcement, Long> {
}
