package com.echipa3.backend.controllers;

import com.echipa3.backend.dtos.ApplicationUserDto;
import com.echipa3.backend.entities.ApplicationUser;
import com.echipa3.backend.entities.Company;
import com.echipa3.backend.services.ICompanyService;
import com.echipa3.backend.services.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;
    private ICompanyService companyService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(IUserService userService, ICompanyService companyService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.companyService = companyService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public Company signUp(@RequestBody ApplicationUserDto applicationUserDto) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(applicationUserDto.getUsername());
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUserDto.getPassword()));
        ApplicationUser newUser = userService.saveOrUpdate(applicationUser);
        Company company = new Company();
        company.setCompanyId(newUser.getId());
        company.setName(applicationUserDto.getName());
        company.setTelephone(applicationUserDto.getTelephone());
        company.setEmail(applicationUserDto.getEmail());
        company.setAnnouncements(new ArrayList<>());
        return companyService.saveOrUpdate(company);
    }
}
