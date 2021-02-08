package com.echipa3.backend.services;

import com.echipa3.backend.entities.AnnouncementTag;
import com.echipa3.backend.entities.Key_AnnouncementTag;

import java.util.Set;

public interface IAnnouncementTagService {
    Set<AnnouncementTag> getAll();

    AnnouncementTag get(Key_AnnouncementTag key_announcementTag);

    void saveOrUpdate(AnnouncementTag announcementTag);

    void delete(Key_AnnouncementTag key_announcementTag);
}
