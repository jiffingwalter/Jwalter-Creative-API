package com.jiffingwalter.jwalter_creative_api;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gallery_item")
public class GalleryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String urlPath;
    private Integer dateUploaded;
    private Integer dateCreated;

    public GalleryItem(){
    }

    public GalleryItem(Integer id, String title, String description, String urlPath, Integer dateUploaded, Integer dateCreated){
        this.id = id;
        this.title = title;
        this.description = description;
        this.urlPath = urlPath;
        this.dateUploaded = dateUploaded;
        this.dateCreated = dateCreated;
    }

    public Integer getId(){
        return this.id;
    }
    public Integer setId(Integer id){
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
    public String getUrlPath(){
        return this.urlPath;
    }
    public String setUrlPath(String urlPath){
        return this.urlPath = urlPath;
    }
    public Integer getDateUploaded(){
        return this.dateUploaded;
    }
    public Integer setDateUploaded(Integer dateUploaded){
        return this.dateUploaded = dateUploaded;
    }
    public Integer getDateCreated(){
        return this.dateUploaded;
    }
    public Integer setDateCreated(Integer dateCreated){
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
            Objects.equals(urlPath, that.urlPath) && 
            Objects.equals(dateUploaded, that.dateUploaded) && 
            Objects.equals(dateCreated, that.dateCreated)
            );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, description, urlPath, dateUploaded, dateCreated);
    }
}
