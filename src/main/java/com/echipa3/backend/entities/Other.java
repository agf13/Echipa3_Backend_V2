package com.echipa3.backend.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Others")
public class Other implements Serializable {


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id", insertable = false, updatable = false)
    private Announcement announcement;

    @Id
    @NotNull
    @Column(name = "announcement_id")
    Long id;

    @Column(name = "details")
    String details;



    public Other() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Other{" +
                "announcement=" + announcement +
                ", id=" + id +
                ", details='" + details + '\'' +
                '}';
    }
}
