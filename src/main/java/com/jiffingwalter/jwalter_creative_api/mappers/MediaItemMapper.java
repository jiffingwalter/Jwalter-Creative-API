package com.jiffingwalter.jwalter_creative_api.mappers;

import com.jiffingwalter.jwalter_creative_api.dtos.MediaDTO;
import com.jiffingwalter.jwalter_creative_api.entities.MediaItem;

public class MediaItemMapper {
    public static MediaDTO toDTO(MediaItem mediaEntity){
        return new MediaDTO(
            mediaEntity.getId(),
            mediaEntity.getTitle(),
            mediaEntity.getExtention(),
            mediaEntity.getType()
            //mediaEntity.getRefUrl()
        );
    }
    public static MediaItem toEntity(MediaDTO mediaDTO){
        MediaItem mediaEntity = new MediaItem();
        mediaEntity.setTitle(mediaDTO.getTitle());
        mediaEntity.setType(mediaDTO.getType());
        mediaEntity.setExtention(mediaDTO.getExtention());
        //mediaEntity.setRefUrl(mediaDTO.getRefUrl())
        return mediaEntity;
    }
}
