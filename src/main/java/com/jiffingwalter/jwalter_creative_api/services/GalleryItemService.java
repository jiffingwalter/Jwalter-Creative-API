package com.jiffingwalter.jwalter_creative_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

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

    public GalleryItem insertGalleryItem(GalleryItem newGalleryItem) {
        return this.galleryItemRepository.save(newGalleryItem);
    }

    public Optional<GalleryItem> getGalleryItemById(UUID id) {
        return this.galleryItemRepository.findById(id);
    }
}
