package com.echipa3.backend.services;

import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnnouncementServiceImpl implements IAnnouncementService{

    @Autowired
    IRepoAnnouncement repository;
    @Autowired
    IRepoContest repoContest;
    @Autowired
    IRepoCourse repoCourse;
    @Autowired
    IRepoInternship repoInternship;
    @Autowired
    IRepojob repojob;
    @Autowired
    IRepoOther repoOther;
    @Autowired
    IRepoScholarship repoScholarship;

    @Override
    public List<Announcement> getAll() {
        return (List<Announcement>)repository.findAll();
    }

    @Override
    public Announcement getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Announcement saveOrUpdate(Announcement entity) {
        return repository.save(entity);
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public String getType(Long id) {
        if(repoContest.findById(id).isPresent())
            return "contest";
        if(repoCourse.findById(id).isPresent()){
            return "course";
        }
        if(repoInternship.findById(id).isPresent()){
            return "internship";
        }
        if(repojob.findById(id).isPresent()){
            return "job";
        }
        if(repoOther.findById(id).isPresent()){
            return "other";
        }
        if(repoScholarship.findById(id).isPresent()){
            return "scholarship";
        }
        return "not found";
    }
}
