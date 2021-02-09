package com.echipa3.backend.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Key_AnnouncementTag implements Serializable {

    @Column(name = "announcement_id")
    Long announcementId;

    @Column(name = "tag_id")
    Long tagId;



    public Key_AnnouncementTag() {}


    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }


    //for some reasons, the equals method needs to be overridden
    @Override
    public boolean equals(Object o){
        //check if o isn't actually the same object as the one it is compared to
        if(o == this)
            return true;

        //check if o is of the same type as Key_AnnouncementTag
        if(!(o instanceof Key_AnnouncementTag))
            return false;

        //convert o from object to Key_AnnouncementTag
        Key_AnnouncementTag theOtherObject = (Key_AnnouncementTag)o;

        //check if the id's are equal
        if(this.announcementId != theOtherObject.announcementId
                || this.tagId != theOtherObject.tagId)
            return false;

        return true;
    }

    //the hashcode method needs to be overrriden. This is a function which computes
    // a number given as a parameter. Preferably should return different numbers
    // if given different parameters, but not requiered)
    @Override
    public int hashCode(){
        //with the below implementation, if the function is called on 2 different
        //objects with the same announcement_id, then it will return the same value.
        return Objects.hashCode(announcementId);
    }

    @Override
    public String toString() {
        return "Key_AnnouncementTag{" +
                "announcementId=" + announcementId +
                ", tagId=" + tagId +
                '}';
    }
}
