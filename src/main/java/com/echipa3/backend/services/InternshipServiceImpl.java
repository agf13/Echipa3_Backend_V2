package com.echipa3.backend.services;

import com.echipa3.backend.entities.Internship;
import com.echipa3.backend.repositories.IRepoInternship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InternshipServiceImpl implements IInternshipService{

    @Autowired
    IRepoInternship repository;

    @Override
    public List<Internship> getAll() { return (List<Internship>)repository.findAll(); }

    @Override
    public Internship getById(Long id) { return repository.findById(id).get(); }

    @Override
    public void saveOrUpdate(Internship internship) { repository.save(internship); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
