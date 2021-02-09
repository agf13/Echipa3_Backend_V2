package com.echipa3.backend.services;

import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.entities.Company;
import com.echipa3.backend.repositories.IRepoCompany;
import com.echipa3.backend.repositories.IRepoCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService{

    @Autowired
    IRepoCompany repository;

    @Override
    public List<Company> getAll() {
        return (List<Company>)repository.findAll();
    }

    @Override
    public List<Announcement> getAnnouncements(Long companyId) {
        Company company = repository.findById(companyId).get();
        List<Announcement> announcementList = company.getAnnouncements();
        return announcementList;
    }

    @Override
    public Company getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Company company) {
        repository.save(company);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
