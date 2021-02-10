package com.echipa3.backend.services;

import com.echipa3.backend.entities.Contest;

import java.util.List;

public interface IContestService {
    public List<Contest> getAll();

    public Contest getById(Long id);

    public Contest saveOrUpdate(Contest contest);

    public void delete(Long id);
}
