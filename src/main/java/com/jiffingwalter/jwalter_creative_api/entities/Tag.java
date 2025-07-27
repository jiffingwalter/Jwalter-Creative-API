package com.jiffingwalter.jwalter_creative_api.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tag")
public class Tag{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private GalleryItem galleryItem;

    public Tag(){}
    public Tag(String nameIn){
        this.name = nameIn;
    }

    public String getName(){
        return this.name;
    }
    public String setName(String nameIn){
        return this.name = nameIn;
    }
}