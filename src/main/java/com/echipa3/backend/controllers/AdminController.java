package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Admin;
import com.echipa3.backend.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admins")
public class AdminController {

    @Autowired
    IAdminService service;

    @PostMapping()
    public Admin save(@RequestBody Admin admin){
        service.saveOrUpdate(admin);
        return admin;
    }

    @GetMapping()
    public List<Admin> list(){
        return service.getAll();
    }
}
