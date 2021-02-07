package com.echipa3.backend.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private Long id;


    public Entity(){ this.id = -1L; }

    public Entity(Long id){
        this.id = id;
    }


    public Long getId(){
        return this.id;
    }
}
