package com.echipa3.backend.services;

import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.repositories.IRepoTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements ITagService {

    @Autowired
    IRepoTag repository;

    @Override
    public List<Tag> getAll() {
        return (List<Tag>)repository.findAll();
    }

    @Override
    public Tag getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Tag saveOrUpdate(Tag tag) {
        return repository.save(tag);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
