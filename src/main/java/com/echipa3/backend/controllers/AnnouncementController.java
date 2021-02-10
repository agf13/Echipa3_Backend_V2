package com.echipa3.backend.controllers;

import com.echipa3.backend.dtos.AnnouncementDto;
import com.echipa3.backend.dtos.AnnouncementSaveDto;
import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.services.IAnnouncementService;
import com.echipa3.backend.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/announcements")
public class AnnouncementController {

    @Autowired
    IAnnouncementService service;
    @Autowired
    ITagService tagService;

    /*
    {
    "imageId":1,
    "descriptionId":1,
    "companyId":12,
    "title":"titlu",
    "shortDescription":"abcd",
    "publishedDate": "2020-02-02",
    "link": "link",
    "tags": [1,2,3]
}
     */
    @PostMapping()
    public Announcement save(@RequestBody AnnouncementSaveDto announcementDto){
        Announcement announcement = new Announcement();
        announcement.setTitle(announcementDto.getTitle());
        announcement.setDescriptionId(announcementDto.getDescriptionId());
        announcement.setImageId(announcementDto.getImageId());
        announcement.setShortDescription(announcementDto.getShortDescription());
        announcement.setPublishedDate(announcementDto.getPublishedDate());
        announcement.setLink(announcementDto.getLink());
        announcement.setCompanyId(announcementDto.getCompanyId());
        if(!announcementDto.isPinned()) {
            announcement.setPinned(false);
        }
        if(!announcementDto.isApprovedForPublishing()) {
            announcement.setApprovedForPublishing(false);
        }
        Set<Tag> tags = new HashSet<>();
        for(Long tag: announcementDto.getTags()){
            tags.add(tagService.getById(tag));
        }
        announcement.setTags(tags);
        return service.saveOrUpdate(announcement);
    }

    /*
    {
        "title": "contest",
        "image": {
            "imageId": 1,
            "imageUrl": "abcd"
        },
        "description": {
            "id": 1,
            "text": "descr"
        },
        "shortDescription": "adse",
        "publishedDate": "2021-02-09T22:00:00.000+00:00",
        "approvedForPublishing": true,
        "link": "fiebr",
        "tags": [
            {
                "id": 1,
                "text": "1"
            }
        ],
        "companyId": 12,
        "type": "contest",
        "pinned": true
    }
     */
    @GetMapping()
    public List<AnnouncementDto> list(){
        List<Announcement> announcements = service.getAll();
        List<AnnouncementDto> announcementDtos = new ArrayList<>();
        announcements.forEach(announcement -> {
            AnnouncementDto announcementDto = new AnnouncementDto();
            announcementDto.setTitle(announcement.getTitle());
            announcementDto.setImage(announcement.getImage());
            announcementDto.setDescription(announcement.getDescription());
            announcementDto.setShortDescription(announcement.getShortDescription());
            announcementDto.setPublishedDate(announcement.getPublishedDate());
            announcementDto.setPinned(announcement.isPinned());
            announcementDto.setApprovedForPublishing(announcement.isApprovedForPublishing());
            announcementDto.setLink(announcement.getLink());
            announcementDto.setTags(announcement.getTags());
            announcementDto.setCompanyId(announcement.getCompanyId());
            announcementDto.setType(service.getType(announcement.getId()));
            announcementDtos.add(announcementDto);
        });
        return announcementDtos;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AnnouncementDto getAnnouncementById(@PathVariable("id") Long id) {
        Announcement announcement = service.getById(id);
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setTitle(announcement.getTitle());
        announcementDto.setImage(announcement.getImage());
        announcementDto.setDescription(announcement.getDescription());
        announcementDto.setShortDescription(announcement.getShortDescription());
        announcementDto.setPublishedDate(announcement.getPublishedDate());
        announcementDto.setPinned(announcement.isPinned());
        announcementDto.setApprovedForPublishing(announcement.isApprovedForPublishing());
        announcementDto.setLink(announcement.getLink());
        announcementDto.setTags(announcement.getTags());
        announcementDto.setCompanyId(announcement.getCompanyId());
        announcementDto.setType(service.getType(announcement.getId()));
        return announcementDto;
    }
}
