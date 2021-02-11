package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Course;
import com.echipa3.backend.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    private ICourseService service;

    @PostMapping
    public Course save(@RequestBody Course course){
        return service.saveOrUpdate(course);
    }

    @GetMapping
    public List<Course> list(){ return service.getAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Course getCourseById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping(value = "/update")
    public Course updateAnnouncement(@RequestBody Course contest){
        return this.service.saveOrUpdate(contest);
    }

}
