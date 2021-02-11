package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Other;
import com.echipa3.backend.services.IOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "others")
public class OtherController {

    @Autowired
    private IOtherService service;

    @PostMapping()
    public Other save(@RequestBody Other other){
        return service.saveOrUpdate(other);
    }

    @GetMapping()
    public List<Other> get(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Other getOtherById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping(value = "/update")
    public Other updateAnnouncement(@RequestBody Other other){
        return this.service.saveOrUpdate(other);
    }
}
