package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Announcement;
import com.echipa3.backend.entities.Company;
import com.echipa3.backend.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    ICompanyService service;

    @PostMapping()
    public Company save(@RequestBody Company company){
        return service.saveOrUpdate(company);
    }

    @PostMapping(value = "/goldit/{id}")
    public Company goldIt(@PathVariable("id") Long id){
        return this.service.setGold(id, true);
    }

    @PostMapping(value = "/ungoldit/{id}")
    public Company unGoldIt(@PathVariable("id") Long id){
        return this.service.setGold(id, false);
    }

    @GetMapping(value = "/get")
    public List<Announcement> getAnnouncements(@RequestParam Long companyId){
        return service.getAnnouncements(companyId);
    }

    @GetMapping()
    public List<Company> list(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Company getCompanyById(@PathVariable("id") Long id) {
        return service.getById(id);
    }
}
