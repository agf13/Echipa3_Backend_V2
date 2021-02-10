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

    @PostMapping(value = "pin/{id}")
    public Announcement setPin(@PathVariable("id") Long id){
        return this.service.setIsPinned(id, true);
    }

    @PostMapping(value = "unpin/{id}")
    public Announcement unsetPin(@PathVariable("id") Long id){
        return this.service.setIsPinned(id, false);
    }

    @PostMapping(value = "approve/{id}")
    public Announcement approveAnnouncement(@PathVariable("id") Long id){
        return this.service.setApprovedForPublishing(id, true);
    }

    @PostMapping(value = "unapprove/{id}")
    public Announcement unapproveAnnouncement(@PathVariable("id") Long id){
        return this.service.setApprovedForPublishing(id, false);
    }

    @PostMapping(value = "/update")
    public Announcement updateAnnouncement(@RequestBody AnnouncementSaveDto announcementSaveDto){
        Announcement announcement = convertFromSaveAnnouncementDto(announcementSaveDto);
        return this.service.saveOrUpdate(announcement);
    }

    /*
    {
        "id": 1,
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
        List<Announcement> resultList = new ArrayList<>();
        List<Announcement> goldList = new ArrayList<>();
        List<Announcement> theRestList = new ArrayList<>();
        for(Announcement announcement : service.getAll()){
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
        resultList.addAll(goldList);
        resultList.addAll(theRestList);
        List<AnnouncementDto> announcementDtos = new ArrayList<>();
        resultList.forEach(announcement -> {
            AnnouncementDto announcementDto = new AnnouncementDto();
            announcementDto.setId(announcement.getId());
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
        announcementDto.setId(announcement.getId());
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

    @GetMapping(value = "approved")
    public List<AnnouncementDto> listApproved(){
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
        List<AnnouncementDto> announcementDtos = new ArrayList<>();
        resultList.forEach(announcement -> {
            AnnouncementDto announcementDto = new AnnouncementDto();
            announcementDto.setId(announcement.getId());
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

    @GetMapping(value = "/unapproved")
    public List<AnnouncementDto> listUnapproved(){
        List<Announcement> announcementList = new ArrayList<>();
        List<Announcement> result = new ArrayList<>();
        for(Announcement announcement : this.service.getAll()){
            if(announcement.isApprovedForPublishing() == false)
                result.add(announcement);
        }
        List<AnnouncementDto> announcementDtos = new ArrayList<>();
        result.forEach(announcement -> {
            AnnouncementDto announcementDto = new AnnouncementDto();
            announcementDto.setId(announcement.getId());
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

    @GetMapping(value = "/bycompany/id/{companyId}")
    public List<AnnouncementDto> getByCompany(@PathVariable("companyId") Long companyId){
        List<Announcement> announcementList = new ArrayList<>();
        for(Announcement announcement : this.service.getAll()){
            if(announcement.getCompanyId() == companyId)
                announcementList.add(announcement);
        }
        announcementList = orderAnnouncements(announcementList);

        return convertToListDto(announcementList);
    }

    @GetMapping(value = "/bycompany/name/{companyname}")
    public List<AnnouncementDto> getByCompanyName(@PathVariable("companyname") String companyName){
        List<Announcement> announcementList = new ArrayList<>();
        for(Announcement announcement : this.service.getAll()){
            if(announcement.methodToGetTheCompany().getName().toLowerCase().contains(companyName.toLowerCase())){
                announcementList.add(announcement);
            }
        }
        announcementList = orderAnnouncements(announcementList);
        return convertToListDto(announcementList);
    }





    ///some utility functions below

    //take a list o announcements and orders it
    private List<Announcement> orderAnnouncements(List<Announcement> announcementList){
        List<Announcement> result = new ArrayList<>();
        List<Announcement> goldList = new ArrayList<>();
        List<Announcement> theRestOfThem = new ArrayList<>();

        for(Announcement announcement : announcementList){
            if(announcement.isPinned())
                result.add(announcement);
            else if(announcement.methodToGetTheCompany().isIs_gold())
                goldList.add(announcement);
            else
                theRestOfThem.add(announcement);
        }
        result.addAll(goldList);
        result.addAll(theRestOfThem);

        return result;
    }

    private AnnouncementDto convertToDto(Announcement announcement){
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setId(announcement.getId());
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

    private Announcement convertFromDto(AnnouncementDto announcementDto){
        Announcement announcement = new Announcement();

        announcement.setId(announcementDto.getId());
        announcement.setTitle(announcementDto.getTitle());
        announcement.setImage(announcementDto.getImage());
        announcement.setDescription(announcementDto.getDescription());
        announcement.setShortDescription(announcementDto.getShortDescription());
        announcement.setPublishedDate(announcementDto.getPublishedDate());
        announcement.setPinned(announcementDto.isPinned());
        announcement.setApprovedForPublishing(announcementDto.isApprovedForPublishing());
        announcement.setLink(announcementDto.getLink());
        announcement.setTags(announcementDto.getTags());
        announcement.setCompanyId(announcementDto.getCompanyId());

        return announcement;
    }

    private Announcement convertFromSaveAnnouncementDto(AnnouncementSaveDto announcementSaveDto){
        Announcement announcement = new Announcement();

        announcement.setId(announcementSaveDto.getId());
        announcement.setTitle(announcementSaveDto.getTitle());
        announcement.setImageId(announcementSaveDto.getImageId());
        announcement.setDescriptionId(announcementSaveDto.getDescriptionId());
        announcement.setShortDescription(announcementSaveDto.getShortDescription());
        announcement.setPublishedDate(announcementSaveDto.getPublishedDate());
        announcement.setPinned(announcementSaveDto.isPinned());
        announcement.setApprovedForPublishing(announcementSaveDto.isApprovedForPublishing());
        announcement.setLink(announcementSaveDto.getLink());
        //the list of tags id's from Dto is not used. (I don't know how. Not anything planned)
        announcement.setCompanyId(announcementSaveDto.getCompanyId());

        return announcement;
    }

    private List<AnnouncementDto> convertToListDto(List<Announcement> announcementList){
        List<AnnouncementDto> dtos = new ArrayList<>();
        announcementList.forEach(announcement -> {
            dtos.add(convertToDto(announcement));
        });
        return dtos;
    }
}
