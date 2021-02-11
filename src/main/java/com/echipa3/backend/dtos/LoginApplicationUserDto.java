package com.echipa3.backend.dtos;

import java.io.Serializable;

public class LoginApplicationUserDto implements Serializable {
    private String username;
    private String password;

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

    public LoginApplicationUserDto() {
    }

    public LoginApplicationUserDto(String username, String password) {

        this.username = username;
        this.password = password;
    }
}
