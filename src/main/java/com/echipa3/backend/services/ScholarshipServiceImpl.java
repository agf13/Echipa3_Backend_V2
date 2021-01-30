package com.echipa3.backend.services;

import com.amazonaws.services.ec2.model.ScheduledInstance;
import com.echipa3.backend.entities.Scholarship;
import com.echipa3.backend.repositories.IRepoScholarship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScholarshipServiceImpl implements IScholarshipService{

    @Autowired
    private IRepoScholarship repository;

    @Override
    public List<Scholarship> getAll() {
        return (List<Scholarship>)repository.findAll();
    }

    @Override
    public Scholarship get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Scholarship scholarship) {
        repository.save(scholarship);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
