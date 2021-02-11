package com.echipa3.backend.services;

import com.echipa3.backend.entities.Tag;

import java.util.List;

public interface ITagService {
    public List<Tag> getAll();

    public Tag getById(Long id);

    public Tag findTagByText(String text);

    public boolean isTagText(String text);

    public Tag saveOrUpdate(Tag tag);

    public void delete(Long id);
}
