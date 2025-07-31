package com.jiffingwalter.jwalter_creative_api.dtos;

public class TagDTO {
    private String name;

    public TagDTO(String name){
        this.name = name;
    }

    public String setName(String name){
        return this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
