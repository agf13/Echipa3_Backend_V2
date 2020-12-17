package com.echipa3.backend.entities;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

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

    @ManyToMany
    private List<Announcement> announcementList;

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

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", announcementList=" + announcementList +
                '}';
    }
}
