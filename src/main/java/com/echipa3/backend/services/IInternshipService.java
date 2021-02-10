package com.echipa3.backend.services;

import com.echipa3.backend.entities.Internship;

import java.util.List;

public interface IInternshipService {
    public List<Internship> getAll();

    public Internship getById(Long id);

    public Internship saveOrUpdate(Internship internship);

    public void delete(Long id);
}
