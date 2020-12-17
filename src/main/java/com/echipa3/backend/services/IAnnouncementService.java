package com.echipa3.backend.services;

import com.echipa3.backend.entities.Announcement;

import java.util.List;

public interface IAnnouncementService {
    public List<Announcement> getAll();

    public Announcement getById(Long id);

    public void saveOrUpdate(Announcement entity);

    public void delete(Long id);
}
