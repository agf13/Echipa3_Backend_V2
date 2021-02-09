package com.echipa3.backend.services;

import com.echipa3.backend.entities.ApplicationUser;
import com.echipa3.backend.repositories.IRepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IRepoUser repoUser;

    @Override
    public List<ApplicationUser> getAll() {
        return repoUser.findAll();
    }

    @Override
    public ApplicationUser getById(Long id) {
        return repoUser.findById(id).get();
    }

    @Override
    public ApplicationUser getByUsername(String username) {
        return repoUser.findByUsername(username);
    }

    @Override
    public ApplicationUser saveOrUpdate(ApplicationUser applicationUser) {
        return repoUser.save(applicationUser);
    }

    @Override
    public void delete(Long id) {
        repoUser.deleteById(id);
    }
}
