package com.jiffingwalter.jwalter_creative_api.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "media_item")
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String extention;
    private String type;
    private LocalDateTime loadDate;

    @ManyToMany(mappedBy = "content")
    private List<GalleryItem> parentGalleryItems;

    public MediaItem(){}

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

    public String getExtention(){
        return this.extention;
    }
    public String setExtention(String extention){
        return this.extention = extention;
    }

    public String getType(){
        return this.type;
    }
    public String setType(String type){
        return this.type = type;
    }

    public LocalDateTime getLoadDate(){
        return this.loadDate;
    }
    public LocalDateTime setLoadDate(LocalDateTime loadDate){
        return this.loadDate = loadDate;
    }

    @Override
    public boolean equals(Object in){
        if (in == null || getClass() != in.getClass())
            return false;
        MediaItem that = (MediaItem) in;
        return (
            Objects.equals(id, that.id) && 
            Objects.equals(title, that.title) &&
            Objects.equals(extention, that.extention) && 
            Objects.equals(type, that.type) && 
            Objects.equals(loadDate, that.loadDate)
            );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, extention, type, loadDate);
    }
}
