package com.jiffingwalter.jwalter_creative_api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiffingwalter.jwalter_creative_api.dtos.GalleryItemDTO;
import com.jiffingwalter.jwalter_creative_api.entities.GalleryItem;
import com.jiffingwalter.jwalter_creative_api.mappers.GalleryItemMapper;
import com.jiffingwalter.jwalter_creative_api.services.GalleryItemService;

@RestController
@RequestMapping("api/v1/gallery-item")
public class GalleryItemController {
    private final GalleryItemService galleryItemService;

    public GalleryItemController(GalleryItemService galleryItemService) {
        this.galleryItemService = galleryItemService;
    }

    /** API - Get all current gallery items in the GalleryItem table */
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("get")
    public List<GalleryItemDTO> getGalleryItems() {
        List<GalleryItem> itemDTOs = galleryItemService.getAllGalleryItems();
        return itemDTOs.stream()
            .map(GalleryItemMapper::toDTO)
            .collect(Collectors.toList());
    }

    /** API - Get a single gallery item in the GalleryItem table */
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("get/{id}")
    public ResponseEntity<GalleryItemDTO> getGalleryItemById(@PathVariable UUID id){
        Optional<GalleryItem> result = galleryItemService.getGalleryItemById(id);
        if (result.isPresent()){
            GalleryItemDTO resultDTO = GalleryItemMapper.toDTO(result.get());
            return ResponseEntity.ok(resultDTO);
        }
        else
            return ResponseEntity.notFound().build();
    }

    /** API - Accept a list of gallery items and insert a new record */
    @PostMapping("create")
    public ResponseEntity<List<GalleryItem>> addNewGalleryItem(@RequestBody List<GalleryItemDTO> newGalleryItem) {
        return ResponseEntity.ok(this.galleryItemService.insertGalleryItems(newGalleryItem));
    }
}
