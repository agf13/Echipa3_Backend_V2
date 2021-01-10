package com.echipa3.backend.services;

import com.echipa3.backend.entities.Admin;
import com.echipa3.backend.repositories.IRepoAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    IRepoAdmin repository;

    @Override
    public List<Admin> getAll() {
        return (List<Admin>)repository.findAll();
    }

    @Override
    public Admin getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Admin admin) {
        repository.save(admin);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
