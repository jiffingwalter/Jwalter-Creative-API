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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="tag")
public class Tag{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private LocalDateTime loadDate;

    @ManyToMany(mappedBy = "tags")
    private List<GalleryItem> galleryItems;

    @PrePersist
    protected void onCreate(){
        this.loadDate = LocalDateTime.now();
    }

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

    public LocalDateTime getLoadDate(){
        return this.loadDate;
    }
    public LocalDateTime setLoadDate(LocalDateTime loadDateIn){
        return this.loadDate = loadDateIn;
    }

    @Override
    public boolean equals(Object in){
        if (in == null || getClass() != in.getClass())
            return false;
        Tag that = (Tag) in;
        return (
            Objects.equals(id, that.id) && 
            Objects.equals(name, that.name) &&
            Objects.equals(loadDate, that.loadDate)
            );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, loadDate);
    }
}