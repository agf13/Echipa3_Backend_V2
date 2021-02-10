package com.echipa3.backend.services;

import com.echipa3.backend.entities.Scholarship;

import java.util.List;

public interface IScholarshipService {
    public List<Scholarship> getAll();

    public Scholarship get(Long id);

    public Scholarship saveOrUpdate(Scholarship scholarship);

    public void delete(Long id);
}
