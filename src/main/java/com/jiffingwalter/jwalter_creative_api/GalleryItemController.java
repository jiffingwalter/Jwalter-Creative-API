package com.jiffingwalter.jwalter_creative_api;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/get-gallery-items")
public class GalleryItemController {
    private final GalleryItemService galleryItemService;

    public GalleryItemController(GalleryItemService galleryItemService){
        this.galleryItemService = galleryItemService;
    }
    
    @GetMapping
    public List<GalleryItem> getGalleryItems(){
        return galleryItemService.getAllGalleryItems();
        //return this.generateMockList();
    }
    
    public List<GalleryItem> generateMockList(){
        return List.of(
            new GalleryItem(
                1,
                "Test 1",
                "Yo momma",
                LocalDateTime.of(2025,05,27,0,0,0),
                LocalDateTime.of(2025,05,27,0,0,0)
            ),
            new GalleryItem(
                2,
                "Test 2",
                "Yo momma",
                LocalDateTime.of(2025,05,27,0,0,0),
                LocalDateTime.of(2025,05,27,0,0,0)
            ),
            new GalleryItem(
                2,
                "Test 3",
                "Yo momma",
                LocalDateTime.of(2025,05,27,0,0,0),
                LocalDateTime.of(2025,05,27,0,0,0)
            ),
            new GalleryItem(
                2,
                "Test 4",
                "Yo momma",
                LocalDateTime.of(2025,05,27,0,0,0),
                LocalDateTime.of(2025,05,27,0,0,0)
            )
        );
    }
    
}
