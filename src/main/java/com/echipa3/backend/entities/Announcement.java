package com.echipa3.backend.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
    @JoinColumn(name = "description_id", referencedColumnName = "description_id", insertable = false, updatable = false)
    private Description description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "image_id", insertable = false, updatable = false)
    private Image image;

    @Column(name = "image_id")
    @NotNull
    Long imageId;

    @Column(name = "description_id")
    @NotNull
    Long descriptionId;

    @Column(name = "short_description")
    @NotNull
    private String shortDescription;

    @Column(name = "publish_date")
    @NotNull
    private Date publishedDate;

    @Column(name = "is_pinned")
    @NotNull
    private boolean isPinned;

    @Column(name = "approved_for_publishing")
    @NotNull
    private boolean approvedForPublishing;

    @Column(name = "link")
    private String link;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "announcementstags",
//            joinColumns = {
//                    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id",
//                            nullable = false, updatable = false)})
//    private Set<Tag> tagList;
    @ManyToMany
    @JoinTable(
            name = "announcementstags",
            joinColumns = @JoinColumn(name = "announcement_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable = false, updatable = false)
    Company company;

    @Column(name = "company_id")
    @NotNull
    Long companyId;

//    public Announcement(Long id, String title, Description description, String shortDescription, Date publishedDate, Integer importance, boolean approvedForPublishing, String link, List<Tag> tags) {
////        super(id);
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.shortDescription = shortDescription;
//        this.publishedDate = publishedDate;
//        this.importance = importance;
//        this.approvedForPublishing = approvedForPublishing;
//        this.link = link;
//        this.tags = tags;
//    }

//    public Announcement(Long id) {
//        super(id);
//    }

    public Announcement(){

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

//    public Company getCompany() {
//        return company;
//    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Long descriptionId) {
        this.descriptionId = descriptionId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId(){ return this.id; }

    public void setId(Long id){ this.id = id; }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() { return description; }

    public void setDescription(Description description) { this.description = description; }


    public String getShortDescription() { return this.shortDescription; }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }


    public Date getPublishedDate() { return publishedDate; }

    public void setPublishedDate(Date publishedDate) { this.publishedDate = publishedDate; }

    public boolean getIsPinned() { return isPinned; }

    public void setIsPinned(boolean isPinned) { this.isPinned = isPinned; }

    public boolean isApprovedForPublishing() { return approvedForPublishing;}

    public void setApprovedForPublishing(boolean approvedForPublishing) { this.approvedForPublishing = approvedForPublishing; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link;}

//    public List<Tag> getTags() {return tags;}
//    public void setTags(List<Tag> tags) {this.tags = tags; }

//    public Set<AnnouncementTag> getAnnouncementTagsList() {
//        return announcementTagsList;
//    }
//
//    public void setAnnouncementTagsList(Set<AnnouncementTag> announcementTagsList) {
//        this.announcementTagsList = announcementTagsList;
//    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description=" + description +
                ", shortDescription='" + shortDescription + '\'' +
                ", publishedDate=" + publishedDate +
                ", isPinned=" + isPinned +
                ", approvedForPublishing=" + approvedForPublishing +
                ", link='" + link + '\'' +
                ", tags=" + tags +
                '}';
    }
}
