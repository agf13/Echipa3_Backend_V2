package com.echipa3.backend.entities;


import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Table(name = "announcementstags")
public class AnnouncementTag implements Serializable {

    @EmbeddedId
    private Key_AnnouncementTag id;

    @ManyToOne
    @MapsId("announcementId")
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id", insertable = false, updatable = false)
    private Announcement announcementObject;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id", insertable = false, updatable = false)
    private Tag tagObject;



    public AnnouncementTag() {
        System.out.println("ann_tag construcor ");
    }


    public Key_AnnouncementTag getId() {
        System.out.println("getId from announcementTag: " + this.id.toString());
        return id;
    }

    public void setId(Key_AnnouncementTag id) {
        System.out.println("Set announcementTag id");
        this.id = id;
    }

    public Announcement getAnnouncement() {
        System.out.println("Get AnnouncementTag method");
        return announcementObject;
    }

    public void setAnnouncementObject(Announcement announcementObject) {
        System.out.println("Set announcementTag announcementObject");
        this.announcementObject = announcementObject;
    }

    public Tag getTag() {
        System.out.println("get announcementTag tag");
        return tagObject;
    }


    @Override
    public String toString() {
        return "AnnouncementTag{" +
                "id=" + id +
                ", announcement=" + announcementObject +
                ", tag=" + tagObject +
                '}';
    }
}
