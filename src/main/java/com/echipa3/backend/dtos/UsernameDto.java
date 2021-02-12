package com.echipa3.backend.dtos;

import java.io.Serializable;

public class UsernameDto implements Serializable {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsernameDto() {
    }

    public UsernameDto(String username) {
        this.username = username;
    }
}
