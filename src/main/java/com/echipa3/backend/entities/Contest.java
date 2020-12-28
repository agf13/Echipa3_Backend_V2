package com.echipa3.backend.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contests")
public class Contest implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id", insertable = false, updatable = false)
    private Announcement announcement;

    @Id
    @NotNull
    @Column(name = "announcement_id")
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "date")
    private Date date;

    @Column(name = "limit_date")
    private Date limitDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "prizes")
    private String prizes;


    public Contest() {}


    public Announcement getAnnouncement() {
        return announcement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPrizes() {
        return prizes;
    }

    public void setPrizes(String prizes) {
        this.prizes = prizes;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "announcement=" + announcement +
                ", id=" + id +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", limitDate=" + limitDate +
                ", price=" + price +
                ", prizes='" + prizes + '\'' +
                '}';
    }
}
