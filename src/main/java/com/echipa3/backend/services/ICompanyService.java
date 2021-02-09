package com.echipa3.backend.services;

import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.entities.Company;

import java.util.List;

public interface ICompanyService {
    public List<Company> getAll();
    public List<Announcement> getAnnouncements(Long companyId);

    public Company getById(Long id);

    public Company saveOrUpdate(Company company);

    public void delete(Long id);
}
