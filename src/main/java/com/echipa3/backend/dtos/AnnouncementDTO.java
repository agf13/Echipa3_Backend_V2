package com.echipa3.backend.dtos;

import java.io.Serializable;

public class AnnouncementDTO implements Serializable {

    private String type;
    private String title;
    private String shortDescription;
    private String publishDate;
    private Boolean approvedForPublishing;
    private String link;
    private Long company_id;
    private Integer importance;

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Boolean getApprovedForPublishing() {
        return approvedForPublishing;
    }

    public void setApprovedForPublishing(Boolean approvedForPublishing) {
        this.approvedForPublishing = approvedForPublishing;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public AnnouncementDTO(String type, String title, String shortDescription, String publishDate, Boolean approvedForPublishing, String link, Long company_id) {
        this.type = type;
        this.title = title;
        this.shortDescription = shortDescription;
        this.publishDate = publishDate;
        this.approvedForPublishing = approvedForPublishing;
        this.link = link;
        this.company_id = company_id;
    }
}
