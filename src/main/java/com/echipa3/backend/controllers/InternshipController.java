package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Internship;
import com.echipa3.backend.services.IInternshipService;
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
        //internship.setLimitDate(new Date());
        //internship.setStartDate(new Date());
        return service.saveOrUpdate(internship);
    }

    @GetMapping()
    public List<Internship> list(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Internship getInternshipById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping(value = "/update")
    public Internship updateAnnouncement(@RequestBody Internship inter){
        return this.service.saveOrUpdate(inter);
    }
}
