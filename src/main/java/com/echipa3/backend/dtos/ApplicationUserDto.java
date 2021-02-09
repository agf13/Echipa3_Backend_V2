package com.echipa3.backend.dtos;

import java.io.Serializable;

public class ApplicationUserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String telephone;
    private String email;
    private Boolean is_gold;

    public ApplicationUserDto(Long id, String username, String password, String name, String telephone, String email, Boolean is_gold) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.is_gold = is_gold;
    }

    public ApplicationUserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_gold() {
        return is_gold;
    }

    public void setIs_gold(Boolean is_gold) {
        this.is_gold = is_gold;
    }
}
