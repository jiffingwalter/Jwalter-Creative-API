package com.jiffingwalter.jwalter_creative_api.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "gallery_item")
public class GalleryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    @Column(length = 2048)
    private String description;
    private LocalDateTime loadDate;
    private LocalDateTime postDate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "gallery_item_media",
        joinColumns = @JoinColumn(name = "gallery_item_id"),
        inverseJoinColumns = @JoinColumn(name = "media_item_id"))
    private List<MediaItem> content;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "gallery_item_tags", 
        joinColumns = @JoinColumn(name = "gallery_item_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @PrePersist
    protected void onCreate(){
        this.loadDate = LocalDateTime.now();
    }

    public GalleryItem(){}

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

    public List<MediaItem> getContent(){
        return this.content;
    }
    public List<MediaItem> setContent(List<MediaItem> content){
        return this.content = content;
    }
    
    public List<Tag> getTags(){
        return this.tags;
    }
    public List<Tag> setTags(List<Tag> tags){
        return this.tags = tags;
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
            Objects.equals(postDate, that.postDate) &&
            Objects.equals(content, that.content) &&
            Objects.equals(tags, that.tags)
            );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, description, content, tags, loadDate, postDate);
    }
}
