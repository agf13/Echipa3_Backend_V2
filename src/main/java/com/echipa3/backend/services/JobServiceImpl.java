package com.echipa3.backend.services;

import com.echipa3.backend.entities.Job;
import com.echipa3.backend.repositories.IRepojob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements IJobService{

    @Autowired
    private IRepojob repository;

    @Override
    public List<Job> getAll() { return (List<Job>)repository.findAll(); }

    @Override
    public Job getById(Long id) { return repository.findById(id).get(); }

    @Override
    public Job saveOrUpdate(Job job) { return repository.save(job); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
