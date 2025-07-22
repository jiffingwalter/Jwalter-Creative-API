package com.jiffingwalter.jwalter_creative_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jiffingwalter.jwalter_creative_api.entities.GalleryItem;

public interface GalleryItemRepository extends JpaRepository<GalleryItem, UUID>{
    
}
