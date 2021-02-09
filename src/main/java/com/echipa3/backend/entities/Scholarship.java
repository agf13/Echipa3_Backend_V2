package com.echipa3.backend.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "scholarships")
public class Scholarship implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id", insertable = false, updatable = false)
    private Announcement announcement;

    @Id
    @Column(name = "announcement_id")
    @NotNull
    Long id;

    @Column(name = "requirements")
    String requirements;

    @Column(name = "limit_date")
    Date limitDate;

    @Column(name = "no_available_positions")
    int noAvailablePositions;


    public Scholarship() {}


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

    public int getNoAvailablePositions() {
        return noAvailablePositions;
    }

    public void setNoAvailablePositions(int noAvailablePositions) {
        this.noAvailablePositions = noAvailablePositions;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "announcement=" + announcement +
                ", id=" + id +
                ", requirements='" + requirements + '\'' +
                ", limitDate=" + limitDate +
                ", noAvailablePositions=" + noAvailablePositions +
                '}';
    }
}
