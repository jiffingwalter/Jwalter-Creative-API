package com.jiffingwalter.jwalter_creative_api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jiffingwalter.jwalter_creative_api.dtos.GalleryItemDTO;
import com.jiffingwalter.jwalter_creative_api.entities.GalleryItem;
import com.jiffingwalter.jwalter_creative_api.repositories.GalleryItemRepository;

@Service
public class GalleryItemService {
    private final GalleryItemRepository galleryItemRepository;

    public GalleryItemService(GalleryItemRepository galleryItemRepository){
        this.galleryItemRepository = galleryItemRepository;
    }

    public List<GalleryItem> getAllGalleryItems(){
        return galleryItemRepository.findAll();
    }

    public List<GalleryItem> insertGalleryItems(List<GalleryItemDTO> newGalleryItems) {
        List<GalleryItem> newEntities = newGalleryItems.stream().map(
                itemDTO -> {
                    GalleryItem itemEntity = new GalleryItem();
                    itemEntity.setTitle(itemDTO.getTitle());
                    itemEntity.setDescription(itemDTO.getDescription());
                    itemEntity.setPostDate((itemDTO.getPostDate().isEmpty())? LocalDateTime.now() : LocalDateTime.parse(itemDTO.getPostDate() ));
                    itemEntity.setLoadDate(LocalDateTime.now());
                    return itemEntity;
                }
            ).toList();
        // TODO: see about automatically inserting media items and tags here...
        
        return this.galleryItemRepository.saveAll(newEntities);
    }

    public Optional<GalleryItem> getGalleryItemById(UUID id) {
        return this.galleryItemRepository.findById(id);
    }
}
