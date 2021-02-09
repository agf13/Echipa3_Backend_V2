package com.echipa3.backend.services;

import com.echipa3.backend.entities.Internship;
import com.echipa3.backend.entities.Tag;

import java.util.List;

public interface IInternshipService {
    public List<Internship> getAll();

    public Internship getById(Long id);

    public void saveOrUpdate(Internship internship);

    public void delete(Long id);
}
