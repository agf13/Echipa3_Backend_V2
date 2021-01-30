package com.echipa3.backend.services;

import com.echipa3.backend.entities.Other;
import com.echipa3.backend.repositories.IRepoOther;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OtherServiceImpl implements IOtherService{

    @Autowired
    private IRepoOther repository;

    @Override
    public List<Other> getAll() {
        return (List<Other>)repository.findAll();
    }

    @Override
    public Other getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Other other) {
        repository.save(other);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
