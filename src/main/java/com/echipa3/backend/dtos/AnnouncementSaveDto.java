package com.echipa3.backend.dtos;

import java.util.Date;
import java.util.List;

public class AnnouncementSaveDto {

    private String title;
    Long imageId;
    Long descriptionId;
    private String shortDescription;
    private Date publishedDate;
    private boolean isPinned;
    private boolean approvedForPublishing;
    private String link;
    private List<Long> tags;
    Long companyId;

    public AnnouncementSaveDto(String title, Long imageId, Long descriptionId, String shortDescription, Date publishedDate, boolean isPinned, boolean approvedForPublishing, String link, List<Long> tags, Long companyId) {
        this.title = title;
        this.imageId = imageId;
        this.descriptionId = descriptionId;
        this.shortDescription = shortDescription;
        this.publishedDate = publishedDate;
        this.isPinned = isPinned;
        this.approvedForPublishing = approvedForPublishing;
        this.link = link;
        this.tags = tags;
        this.companyId = companyId;
    }

    public AnnouncementSaveDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Long descriptionId) {
        this.descriptionId = descriptionId;
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

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
