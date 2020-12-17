package com.echipa3.backend.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "descriptions")
@javax.persistence.Entity
@AttributeOverride(name = "announcement_id", column = @Column(name="description_id"))
public class Description{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "description_id")
    Long id;

    @Column(name = "text")
    @NotNull
    private String text;

    @OneToOne(mappedBy = "description")
    private Announcement announcement;

    public Description(){ }

    public Description(String text){
        this.text = text;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //public Announcement getAnnouncement() { return this.announcement; }

    //public void setAnnouncement(Announcement announcement) { this.announcement = announcement; }


    public String toString(){
        String output = "";
        output += super.toString() + "; " +
                "Text: " + text;

        return output;
    }

}
