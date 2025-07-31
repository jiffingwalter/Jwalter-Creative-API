package com.jiffingwalter.jwalter_creative_api.dtos;

import java.util.List;
import java.util.UUID;

public class GalleryItemDTO {
    private UUID id;
    private String title;
    private String description;
    private String postDate;
    private List<MediaDTO> content;
    private List<TagDTO> tags;

    public GalleryItemDTO(UUID id, String title, String description, String postDate, List<MediaDTO> content, List<TagDTO> tags){
        this.id = id;
        this.title = title;
        this.description = description;
        this.postDate = postDate;
        this.content = content;
        this.tags = tags;
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
    
    public String getPostDate(){
        return this.postDate;
    }
    public String setPostDate(String postDate){
        return this.postDate = postDate;
    }
    
    public List<MediaDTO> getContent(){
        return this.content;
    }
    public List<MediaDTO> setContent(List<MediaDTO> content){
        return this.content = content;
    }
    
    public List<TagDTO> getTags(){
        return this.tags;
    }
    public List<TagDTO> setTags(List<TagDTO> tags){
        return this.tags = tags;
    }
}
