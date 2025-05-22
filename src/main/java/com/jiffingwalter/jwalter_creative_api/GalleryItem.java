package com.jiffingwalter.jwalter_creative_api;

import java.util.Objects;

public class GalleryItem {
    private int id;
    private String title;
    private String description;
    private String urlPath;
    private int dateUploaded;
    private int dateCreated;

    public GalleryItem(int id, String title, String description, String urlPath, int dateUploaded, int dateCreated){
        this.id = id;
        this.title = title;
        this.description = description;
        this.urlPath = urlPath;
        this.dateUploaded = dateUploaded;
        this.dateCreated = dateCreated;
    }

    public int getId(){
        return this.id;
    }
    public int setId(int id){
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
    public int getDateUploaded(){
        return this.dateUploaded;
    }
    public int setDateUploaded(int dateUploaded){
        return this.dateUploaded = dateUploaded;
    }
    public int getDateCreated(){
        return this.dateUploaded;
    }
    public int setDateCreated(int dateCreated){
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
