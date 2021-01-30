package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Scholarship;
import com.echipa3.backend.services.IScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "scholarships")
public class ScholarshipController {

    @Autowired
    private IScholarshipService service;

    @PostMapping()
    public Scholarship save(@RequestBody Scholarship scholarship){
        service.saveOrUpdate(scholarship);
        return scholarship;
    }

    @GetMapping()
    public List<Scholarship> getAll(){
        return service.getAll();
    }

}
