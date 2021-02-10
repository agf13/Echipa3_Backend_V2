package com.echipa3.backend.controllers;

import com.echipa3.backend.dtos.AnnouncementSaveDto;
import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.services.IAnnouncementService;
import com.echipa3.backend.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public List<Announcement> list(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Announcement getEmployeesByIdWithVariableName(@PathVariable("id") Long id) {
        return service.getById(id);
    }
}
