package com.echipa3.backend.services;

import com.echipa3.backend.entities.Description;
import com.echipa3.backend.repositories.IRepoDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DescriptionServiceImpl implements IDescriptionService{

    @Autowired
    IRepoDescription repository;

    @Override
    public List<Description> getAll() {
        return (List<Description>)repository.findAll();
    }

    @Override
    public Description getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Description description) {
        repository.save(description);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
