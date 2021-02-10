package com.echipa3.backend.services;

import com.echipa3.backend.entities.Job;

import java.util.List;

public interface IJobService {
    public List<Job> getAll();

    public Job getById(Long id);

    public Job saveOrUpdate(Job job);

    public void delete(Long id);
}
