package com.jiffingwalter.jwalter_creative_api.entities;

import java.util.Objects;
import java.util.UUID;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gallery_item")
public class GalleryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private LocalDateTime dateUploaded;
    private LocalDateTime dateCreated;

    public GalleryItem(){
    }

    public GalleryItem(String title, String description, LocalDateTime dateUploaded, LocalDateTime dateCreated){
        //this.id = id;
        this.title = title;
        this.description = description;
        this.dateUploaded = dateUploaded;
        this.dateCreated = dateCreated;
    }

    public UUID getId(){
        return this.id;
    }
    public UUID setId(UUID id){
        return this.id = id;
    }
    public String getTitle(){
        return this.title;
    }
    public String setTitle(String title){
        return this.title = title;
    }
    public String getDescription(){
        return this.description;
    }
    public String setDescription(String description){
        return this.description = description;
    }
    public LocalDateTime getDateUploaded(){
        return this.dateUploaded;
    }
    public LocalDateTime setDateUploaded(LocalDateTime dateUploaded){
        return this.dateUploaded = dateUploaded;
    }
    public LocalDateTime getDateCreated(){
        return this.dateUploaded;
    }
    public LocalDateTime setDateCreated(LocalDateTime dateCreated){
        return this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object in){
        if (in == null || getClass() != in.getClass())
            return false;
        GalleryItem that = (GalleryItem) in;
        return (
            Objects.equals(id, that.id) && 
            Objects.equals(title, that.title) &&
            Objects.equals(description, that.description) && 
            Objects.equals(dateUploaded, that.dateUploaded) && 
            Objects.equals(dateCreated, that.dateCreated)
            );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, description, dateUploaded, dateCreated);
    }
}
