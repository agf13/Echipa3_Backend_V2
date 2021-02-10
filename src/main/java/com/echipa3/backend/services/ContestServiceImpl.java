package com.echipa3.backend.services;

import com.echipa3.backend.entities.Contest;
import com.echipa3.backend.repositories.IRepoContest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContestServiceImpl implements IContestService{

    @Autowired
    private IRepoContest repository;

    @Override
    public List<Contest> getAll() { return (List<Contest>)repository.findAll(); }

    @Override
    public Contest getById(Long id) { return repository.findById(id).get(); }

    @Override
    public Contest saveOrUpdate(Contest contest) { return repository.save(contest); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
