package com.jiffingwalter.jwalter_creative_api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiffingwalter.jwalter_creative_api.entities.GalleryItem;
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
    public List<GalleryItem> getGalleryItems() {
        return galleryItemService.getAllGalleryItems();
    }

    /** API - Get all current gallery items in the GalleryItem table */
    @GetMapping("get/{id}")
    public ResponseEntity<GalleryItem> getGalleryItemById(@PathVariable UUID id){
        Optional<GalleryItem> result = galleryItemService.getGalleryItemById(id);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());
        else
            return ResponseEntity.notFound().build();
    }

    /** API - Accept a gallery item and insert a new record */
    @PostMapping("create")
    public ResponseEntity<GalleryItem> addNewGalleryItem(@RequestBody GalleryItem newGalleryItem) {
        System.out.println(newGalleryItem.toString());
        return ResponseEntity.ok(this.galleryItemService.insertGalleryItem(newGalleryItem));
    }

    /** API to generate test items and then return them in a response call */
    public List<GalleryItem> testInsert() {
        List<GalleryItem> response = List.of(
                new GalleryItem(
                        "Gallery item 1",
                        "Sample description 1",
                        LocalDateTime.of(2025, 03, 01, 0, 0, 0),
                        LocalDateTime.of(2025, 03, 01, 0, 0, 0)
                        ),
                new GalleryItem(
                        "Gallery item 2",
                        "Sample description 2",
                        LocalDateTime.of(2025, 04, 01, 0, 0, 0),
                        LocalDateTime.of(2025, 04, 01, 0, 0, 0)
                        ),
                new GalleryItem(
                        "Gallery item 3",
                        "Sample description 3",
                        LocalDateTime.of(2025, 05, 01, 0, 0, 0),
                        LocalDateTime.of(2025, 05, 01, 0, 0, 0)
                        )
                        );

        return response;
    }

}
