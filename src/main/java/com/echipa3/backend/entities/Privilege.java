package com.echipa3.backend.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String privilege;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege(String privilege) {
        this.privilege = privilege;
    }

    public Privilege(){}

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}