package com.jiffingwalter.jwalter_creative_api.mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jiffingwalter.jwalter_creative_api.dtos.GalleryItemDTO;
import com.jiffingwalter.jwalter_creative_api.dtos.MediaDTO;
import com.jiffingwalter.jwalter_creative_api.dtos.TagDTO;
import com.jiffingwalter.jwalter_creative_api.entities.GalleryItem;
import com.jiffingwalter.jwalter_creative_api.entities.MediaItem;
import com.jiffingwalter.jwalter_creative_api.entities.Tag;

public class GalleryItemMapper {
    public static GalleryItemDTO toDTO(GalleryItem galleryItemEntity){
        List<MediaDTO> contentDTOs = galleryItemEntity.getContent().stream().map(
            mediaEntity -> {
                return MediaItemMapper.toDTO(mediaEntity);
                }
            ).collect(Collectors.toList());
        List<TagDTO> tagDTOs = galleryItemEntity.getTags().stream().map(
            tagEntity -> {
                return TagMapper.toDTO(tagEntity);
                }
            ).collect(Collectors.toList());

        return new GalleryItemDTO(
            galleryItemEntity.getId(),
            galleryItemEntity.getTitle(), 
            galleryItemEntity.getDescription(), 
            galleryItemEntity.getPostDate().toString(), 
            contentDTOs, 
            tagDTOs
        );
    }
    public static GalleryItem toEntity(GalleryItemDTO galleryItemDTO){
        GalleryItem galleryItemEntity = new GalleryItem();
        galleryItemEntity.setTitle(galleryItemDTO.getTitle());
        galleryItemEntity.setDescription(galleryItemDTO.getDescription());
        galleryItemEntity.setPostDate((galleryItemDTO.getPostDate().isEmpty())? LocalDateTime.now() : LocalDateTime.parse(galleryItemDTO.getPostDate() ));
        List<MediaItem> mediaEntities = galleryItemDTO.getContent().stream().map(
            mediaEntity -> {
                //TODO: check for duplicates here
                return MediaItemMapper.toEntity(mediaEntity);
            }
        ).toList();
        galleryItemEntity.setContent(mediaEntities);
        List<Tag> tagEntities = galleryItemDTO.getTags().stream().map(
            tagEntity -> {
                //TODO: check for duplicates here
                return TagMapper.toEntity(tagEntity);
            }
        ).toList();
        galleryItemEntity.setTags(tagEntities);
        return galleryItemEntity;
    }
}
