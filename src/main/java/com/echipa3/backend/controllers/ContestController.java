package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Contest;
import com.echipa3.backend.services.IContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "contests")
public class ContestController {

    @Autowired
    private IContestService service;

    @PostMapping
    public Contest save(@RequestBody Contest contest){
        return service.saveOrUpdate(contest);
    }

    @GetMapping
    public List<Contest> list() { return service.getAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Contest getContestById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

}
