package com.echipa3.backend.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@MappedSuperclass
@Entity
@Table(name = "announcements")
public class Announcement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "announcement_id")
    Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "description_id")
    private Description description;

    @Column(name = "short_description")
    @NotNull
    private String shortDescription;

    @Column(name = "publish_date")
    @NotNull
    private Date publishedDate;

    @Column(name = "importance")
    @NotNull
    private Integer importance;

    @Column(name = "approved_for_publishing")
    @NotNull
    private boolean approvedForPublishing;

    @Column(name = "link")
    private String link;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "announcementstags",
            joinColumns = {
                    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id",
                            nullable = false, updatable = false)})
    private List<Tag> tags;


    public Announcement(Long id, String title, Description description, String shortDescription, Date publishedDate, Integer importance, boolean approvedForPublishing, String link, List<Tag> tags) {
//        super(id);
        this.id = id;
        this.title = title;
        this.description = description;
        this.shortDescription = shortDescription;
        this.publishedDate = publishedDate;
        this.importance = importance;
        this.approvedForPublishing = approvedForPublishing;
        this.link = link;
        this.tags = tags;
    }

//    public Announcement(Long id) {
//        super(id);
//    }

    public Announcement(){

    }

    public Long getId(){ return this.id; }

    public void setId(Long id){ this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public boolean isApprovedForPublishing() {
        return approvedForPublishing;
    }

    public void setApprovedForPublishing(boolean approvedForPublishing) {
        this.approvedForPublishing = approvedForPublishing;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description=" + description +
                ", shortDescription='" + shortDescription + '\'' +
                ", publishedDate=" + publishedDate +
                ", importance=" + importance +
                ", approvedForPublishing=" + approvedForPublishing +
                ", link='" + link + '\'' +
                ", tags=" + tags +
                '}';
    }
}
