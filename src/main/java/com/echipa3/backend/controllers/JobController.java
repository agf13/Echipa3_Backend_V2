package com.echipa3.backend.controllers;


import com.echipa3.backend.entities.Job;
import com.echipa3.backend.services.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "jobs")
public class JobController {

    @Autowired
    private IJobService service;

    @PostMapping
    public Job save(@RequestBody Job job){
        return service.saveOrUpdate(job);
    }

    @GetMapping
    public List<Job> list() { return service.getAll(); }
}
