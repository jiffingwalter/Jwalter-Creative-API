package com.jiffingwalter.jwalter_creative_api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/get-gallery-items")
public class GalleryItemController {

    @GetMapping
    public List<GalleryItem> getGalleryItems(){
        return this.generateMockList();
    }
    
    public List<GalleryItem> generateMockList(){
        return List.of(
            new GalleryItem(
                1,
                "Test 1",
                "Yo momma",
                "https://google.com",
                0,
                0
            ),
            new GalleryItem(
                2,
                "Test 2",
                "Yo momma",
                "https://google.com",
                0,
                0
            ),
            new GalleryItem(
                2,
                "Test 3",
                "Yo momma",
                "https://google.com",
                0,
                0
            ),
            new GalleryItem(
                2,
                "Test 4",
                "Yo momma",
                "https://google.com",
                0,
                0
            )
        );
    }
    
}
