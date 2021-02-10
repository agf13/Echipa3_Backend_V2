package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.services.IAnnouncementService;
import com.echipa3.backend.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/announcements")
public class AnnouncementController {

    @Autowired
    IAnnouncementService service;

//    @PostMapping()
//    public Announcement save(@RequestBody AnnouncementDTO announcementDto){
//        Announcement announcement = new Announcement();
//        announcement.setTitle(announcementDto.getTitle());
//        announcement.setShortDescription(announcementDto.getShortDescription());
//        announcement.setCompanyId(1L);
//        announcement.setDescriptionId(1L);
//        announcement.setPublishedDate(new Date());
//        announcement.setImportance(announcementDto.getImportance());
//        announcement.setApprovedForPublishing(announcementDto.getApprovedForPublishing());
//        announcement.setImageId(1L);
//        //announcement.setApprovedForPublishing(announcementDto.getApprovedForPublishing());
//        service.saveOrUpdate(announcement);
//        return announcement;
//    }


    @PostMapping()
    public Announcement save(@RequestBody Announcement announcement){
        service.saveOrUpdate(announcement);
        return announcement;
    }

    @GetMapping()
    public List<Announcement> list(){
        List<Announcement> resultList = new ArrayList<>();
        List<Announcement> goldList = new ArrayList<>();
        List<Announcement> theRestList = new ArrayList<>();
        for(Announcement announcement : service.getAll()){
            if(announcement.isApprovedForPublishing() == true) {
                //first adding the pinned ones to the results
                if (announcement.isPinned() == true)
                    resultList.add(announcement);
                    //then adding the gold ones to a list that will be concatenated to the result
                else if (announcement.methodToGetTheCompany().isIs_gold() == true) {
                    goldList.add(announcement);
                }
                //then the rest of the announcements in another list
                else
                    theRestList.add(announcement);
            }
        }
        resultList.addAll(goldList);
        resultList.addAll(theRestList);

        return resultList;
    }

    @GetMapping(value = "/unapproved")
    public List<Announcement> listUnapproved(){
        List<Announcement> announcementList = new ArrayList<>();
        List<Announcement> result = new ArrayList<>();
        for(Announcement announcement : announcementList){
            if(announcement.isApprovedForPublishing() == false)
                result.add(announcement);
        }
        return announcementList;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Announcement getAnnouncementById(@PathVariable("id") Long id) {
        return service.getById(id);
    }
}
