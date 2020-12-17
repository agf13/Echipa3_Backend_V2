package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Description;
import com.echipa3.backend.services.IDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/descriptioncontroller")
public class DescrpitionController {

    @Autowired
    IDescriptionService service;

    @PostMapping("/save")
    public Description save(@RequestBody Description description){
        service.saveOrUpdate(description);
        return description;
    }

    @GetMapping("/list")
    public List<Description> list(){
        return service.getAll();
    }
}
