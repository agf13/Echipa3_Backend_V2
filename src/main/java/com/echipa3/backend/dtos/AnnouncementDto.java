package com.echipa3.backend.dtos;

import com.echipa3.backend.entities.Description;
import com.echipa3.backend.entities.Image;
import com.echipa3.backend.entities.Tag;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class AnnouncementDto implements Serializable {
    private Long id;
    private String title;
    private Image image;
    private Description description;
    private String shortDescription;
    private Date publishedDate;
    private boolean isPinned;
    private boolean approvedForPublishing;
    private String link;
    private Set<Tag> tags;
    private Long companyId;
    private String type;

    public AnnouncementDto(Long id, String title, Image image, Description description, String shortDescription, Date publishedDate, boolean isPinned, boolean approvedForPublishing, String link, Set<Tag> tags, Long companyId, String type) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.shortDescription = shortDescription;
        this.publishedDate = publishedDate;
        this.isPinned = isPinned;
        this.approvedForPublishing = approvedForPublishing;
        this.link = link;
        this.tags = tags;
        this.companyId = companyId;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnnouncementDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
