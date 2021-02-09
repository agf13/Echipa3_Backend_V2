package com.echipa3.backend.services;

import com.echipa3.backend.entities.Admin;


import java.util.List;

public interface IAdminService {
    public List<Admin> getAll();

    public Admin getById(Long id);

    public void saveOrUpdate(Admin admin);

    public void delete(Long id);
}
