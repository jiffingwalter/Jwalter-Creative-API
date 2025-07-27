package com.jiffingwalter.jwalter_creative_api.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.time.LocalDateTime;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "gallery_item")
public class GalleryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private LocalDateTime loadDate;
    private LocalDateTime postDate;

    @ManyToMany
    @JoinTable(
        name = "gallery_item_media",
        joinColumns = @JoinColumn(name = "gallery_item_id"),
        inverseJoinColumns = @JoinColumn(name = "media_item_id")
    )
    private List<MediaItem> content;

    @ElementCollection
    @CollectionTable(name = "gallery_item_tags", joinColumns = @JoinColumn(name = "gallery_item_id"))
    @Column(name = "tag")
    private List<String> tags;

    public GalleryItem(){}
    public GalleryItem(String title, String description, LocalDateTime loadDate, LocalDateTime postDate){
        this.title = title;
        this.description = description;
        this.loadDate = loadDate;
        this.postDate = postDate;
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
    public LocalDateTime getLoadDate(){
        return this.loadDate;
    }
    public LocalDateTime setLoadDate(LocalDateTime loadDate){
        return this.loadDate = loadDate;
    }
    public LocalDateTime getPostDate(){
        return this.postDate;
    }
    public LocalDateTime setPostDate(LocalDateTime postDate){
        return this.postDate = postDate;
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
            Objects.equals(loadDate, that.loadDate) && 
            Objects.equals(postDate, that.postDate)
            );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, description, loadDate, postDate);
    }
}
