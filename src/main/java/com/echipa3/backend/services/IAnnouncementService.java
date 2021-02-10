package com.echipa3.backend.services;

import com.echipa3.backend.entities.Announcement;

import java.util.List;

public interface IAnnouncementService {
    public List<Announcement> getAll();

    public Announcement getById(Long id);

    public Announcement saveOrUpdate(Announcement entity);

    public void delete(Long id);

    String getType(Long id);
}
