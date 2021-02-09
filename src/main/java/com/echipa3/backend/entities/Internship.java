package com.echipa3.backend.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "internships")
public class Internship implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id", insertable = false, updatable = false)
    private Announcement announcement;

    @Id
    @NotNull
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "announcement_id")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "requirements")
    private String requirments;

    @Column(name = "no_available_positions")
    private int numberAvailablePositions;

    @Column(name = "limit_date")
    private Date limitDate;



    public Internship(){}



    public Announcement getAnnouncement() {
        return announcement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getRequirments() {
        return requirments;
    }

    public void setRequirments(String requirments) {
        this.requirments = requirments;
    }

    public int getNumberAvailablePositions() {
        return numberAvailablePositions;
    }

    public void setNumberAvailablePositions(int numberAvailablePositions) {
        this.numberAvailablePositions = numberAvailablePositions;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    @Override
    public String toString() {
        return "Internship{" +
                "announcement=" + announcement +
                ", id=" + id +
                ", startDate=" + startDate +
                ", requirments='" + requirments + '\'' +
                ", numberAvailablePositions=" + numberAvailablePositions +
                ", limitDate=" + limitDate +
                '}';
    }
}
