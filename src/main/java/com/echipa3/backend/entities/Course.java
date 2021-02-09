package com.echipa3.backend.entities;

import org.hibernate.exception.DataException;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id", insertable = false, updatable = false)
    private Announcement announcement;

    @Id
    @NotNull
    @Column(name = "announcement_id")
    private Long id;

    @Column(name = "limit_date")
    private Date limitDate;

    @Column(name = "start_date")
    private Date startDate;



    public Course() {}



    public Announcement getAnnouncement() {
        return announcement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "announcement=" + announcement +
                ", id=" + id +
                ", limitDate=" + limitDate +
                ", startDate=" + startDate +
                '}';
    }
}
