package com.jiffingwalter.jwalter_creative_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jiffingwalter.jwalter_creative_api.dtos.GalleryItemDTO;
import com.jiffingwalter.jwalter_creative_api.entities.GalleryItem;
import com.jiffingwalter.jwalter_creative_api.mappers.GalleryItemMapper;
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
                galleryItemDTO -> {
                    return GalleryItemMapper.toEntity(galleryItemDTO);
                }
            ).toList();

        return this.galleryItemRepository.saveAll(newEntities);
    }

    public Optional<GalleryItem> getGalleryItemById(UUID id) {
        return this.galleryItemRepository.findById(id);
    }
}
