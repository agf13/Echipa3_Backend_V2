package com.echipa3.backend.services;

import com.echipa3.backend.entities.Company;

import java.util.List;

public interface ICompanyService {
    public List<Company> getAll();

    public Company getById(Long id);

    public void saveOrUpdate(Company company);

    public void delete(Long id);
}
