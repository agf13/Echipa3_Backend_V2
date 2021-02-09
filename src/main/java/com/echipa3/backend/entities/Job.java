package com.echipa3.backend.entities;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "jobs")
public class Job implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id", insertable = false, updatable = false)
    private Announcement announcement;

    @Id
    @NotNull
    @Column(name = "announcement_id")
    private Long id;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "limit_date")
    private Date limitDate;


    public Job() {}


    public Announcement getAnnouncement() {
        return announcement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    @Override
    public String toString() {
        return "Job{" +
                "announcement=" + announcement +
                ", id=" + id +
                ", requirements='" + requirements + '\'' +
                ", limitDate=" + limitDate +
                '}';
    }
}
