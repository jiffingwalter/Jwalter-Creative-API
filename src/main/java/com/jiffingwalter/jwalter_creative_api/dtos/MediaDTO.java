package com.jiffingwalter.jwalter_creative_api.dtos;

import java.util.UUID;

public class MediaDTO {
    private UUID id;
    private String title;
    private String extention;
    private String type;

    public MediaDTO(UUID id, String title, String extention, String type){
        this.id = id;
        this.title = title;
        this.extention = extention;
        this.type = type;
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
}
