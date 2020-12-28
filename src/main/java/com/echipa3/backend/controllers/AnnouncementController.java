package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.services.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/announcements")
public class AnnouncementController {

    @Autowired
    IAnnouncementService service;

    @PostMapping()
    public Announcement save(@RequestBody Announcement announcement){
        service.saveOrUpdate(announcement);
        return announcement;
    }

    @GetMapping()
    public List<Announcement> list(){
        return service.getAll();
    }
}
