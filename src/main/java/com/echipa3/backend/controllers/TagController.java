package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/tagcontroller")
public class TagController {

    @Autowired
    ITagService service;

    @PostMapping("/save")
    public Tag save(@RequestBody Tag tag){
        service.saveOrUpdate(tag);
        return tag;
    }

    @GetMapping("/list")
    public List<Tag> list(){
        return service.getAll();
    }
}
