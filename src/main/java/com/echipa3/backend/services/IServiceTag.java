package com.echipa3.backend.services;

import com.echipa3.backend.entities.Tag;

import java.util.List;

public interface IServiceTag {
    public List<Tag> getAll();

    public Tag getById(Long id);

    public void saveOrUpdate(Tag tag);

    public void delete(Long id);
}
