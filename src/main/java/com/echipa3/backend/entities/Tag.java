package com.echipa3.backend.entities;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "tags")
@javax.persistence.Entity
@AttributeOverride(name = "announcement_id", column = @Column(name="tag_id"))
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "tag_id")
    Long id;

    @Column(name = "text")
    @NotNull
    private String text;

//    @ManyToMany
//    private Set<Announcement> announcementList;

    @ManyToMany(mappedBy = "tags")
    private Set<Announcement> announcements;

//    @OneToMany(mappedBy = "")
//    List<Announcement> announcementList;

    public Tag(){
        super();
    }

    public Tag(String text){
        super();
        this.text = text;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public void setAnnouncementList(Set<Announcement> announcementList){
//        this.announcementList = announcementList;
//    }
//    public Set<Announcement> getAnnouncementList(){ return this.announcementList; }

//    public Set<AnnouncementTag> getAnnouncementTagsList() {
//        return announcementTagsList;
//    }
//
//    public void setAnnouncementTagsList(Set<AnnouncementTag> announcementTagsList) {
//        this.announcementTagsList = announcementTagsList;
//    }


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
