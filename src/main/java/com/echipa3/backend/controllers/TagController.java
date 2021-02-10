package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    ITagService service;

    @PostMapping()
    public Tag save(@RequestBody Tag tag){
        return service.saveOrUpdate(tag);
    }

    @GetMapping()
    public List<Tag> list(){
        return service.getAll();
    }
}
