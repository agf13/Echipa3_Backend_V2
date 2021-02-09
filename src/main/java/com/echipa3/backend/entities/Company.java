package com.echipa3.backend.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "company_id")
    Long companyId;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "company")
    List<Announcement> announcements;

    @Column(name = "telephone")
    String telephone;

    @Column(name = "email")
    String email;

    @Column(name = "is_gold")
    boolean is_gold;


    public Company() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
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

    public boolean isIs_gold() {
        return is_gold;
    }

    public void setIs_gold(boolean is_gold) {
        this.is_gold = is_gold;
    }


    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", announcements=" + announcements +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", is_gold=" + is_gold +
                '}';
    }
}
