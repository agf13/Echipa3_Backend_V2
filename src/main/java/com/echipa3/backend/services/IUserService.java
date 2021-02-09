package com.echipa3.backend.services;


import com.echipa3.backend.entities.ApplicationUser;

import java.util.List;

public interface IUserService {
    public List<ApplicationUser> getAll();

    public ApplicationUser getById(Long id);

    public ApplicationUser getByUsername(String username);

    public ApplicationUser saveOrUpdate(ApplicationUser ApplicationUser);

    public void delete(Long id);
}