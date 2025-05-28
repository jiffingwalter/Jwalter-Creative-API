package com.jiffingwalter.jwalter_creative_api;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryItemRepository extends JpaRepository<GalleryItem, UUID>{
    
}
