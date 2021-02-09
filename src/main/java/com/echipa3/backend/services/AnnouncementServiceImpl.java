package com.echipa3.backend.services;

import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.repositories.IRepoAnnouncement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OneToMany;
import java.util.List;

@Service
@Transactional
public class AnnouncementServiceImpl implements IAnnouncementService{

    @Autowired
    IRepoAnnouncement repository;

    @Override
    public List<Announcement> getAll() {
        return (List<Announcement>)repository.findAll();
    }

    @Override
    public Announcement getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Announcement entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
