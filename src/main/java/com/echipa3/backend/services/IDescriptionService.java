package com.echipa3.backend.services;

import com.echipa3.backend.entities.Description;

import java.util.List;

public interface IDescriptionService {
    public List<Description> getAll();

    public Description getById(Long id);

    public Description saveOrUpdate(Description description);

    public void delete(Long id);
}
