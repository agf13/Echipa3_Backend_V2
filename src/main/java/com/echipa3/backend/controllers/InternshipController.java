package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Internship;
import com.echipa3.backend.entities.Tag;
import com.echipa3.backend.services.IInternshipService;
import com.echipa3.backend.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/internships")
public class InternshipController {

    @Autowired
    private IInternshipService service;

    @PostMapping()
    public Internship save(@RequestBody Internship internship){
        service.saveOrUpdate(internship);
        return internship;
    }

    @GetMapping()
    public List<Internship> list(){
        return service.getAll();
    }
}
