package com.echipa3.backend.services;

import com.echipa3.backend.entities.Other;

import java.util.List;

public interface IOtherService {
    public List<Other> getAll();

    public Other getById(Long id);

    public Other saveOrUpdate(Other other);

    public void delete(Long id);

}
