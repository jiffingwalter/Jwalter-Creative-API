package com.jiffingwalter.jwalter_creative_api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.jiffingwalter.jwalter_creative_api.dtos.GalleryItemDTO;
import com.jiffingwalter.jwalter_creative_api.dtos.MediaDTO;
import com.jiffingwalter.jwalter_creative_api.entities.GalleryItem;

public class GalleryItemMapper {
    public static GalleryItemDTO toDTO(GalleryItem item){
        List<MediaDTO> contentDTOs = item.getContent().stream().map(
            media -> new MediaDTO(
                media.getId(),
                media.getTitle(),
                media.getExtention(),
                media.getType()
                )
            ).collect(Collectors.toList());
        
        //TODO: see about getting tags here as well...

        return new GalleryItemDTO(
            item.getId(),
            item.getTitle(), 
            item.getDescription(), 
            item.getPostDate().toString(), 
            contentDTOs, 
            item.getTags()
        );
    }
}
