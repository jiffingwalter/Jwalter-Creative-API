package com.jiffingwalter.jwalter_creative_api.mappers;

import com.jiffingwalter.jwalter_creative_api.dtos.TagDTO;
import com.jiffingwalter.jwalter_creative_api.entities.Tag;

public class TagMapper {
    public static TagDTO toDTO(Tag tagEntity){
        return new TagDTO(
            tagEntity.getName()
        );
    }
    public static Tag toEntity(TagDTO tagDTO){
        Tag tagEntity = new Tag();
        tagEntity.setName(tagDTO.getName());
        return tagEntity;
    }
}
