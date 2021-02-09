package com.echipa3.backend.repositories;

import com.echipa3.backend.entities.Image;
import org.springframework.data.repository.CrudRepository;

public interface IRepoImage extends CrudRepository<Image, Long> {
}
