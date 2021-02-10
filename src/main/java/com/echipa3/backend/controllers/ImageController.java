package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Image;
import com.echipa3.backend.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @PostMapping
    public Image saveImage(@RequestParam("image") MultipartFile request) throws IOException {
        Image image = imageService.saveImage(request.getBytes(), request.getOriginalFilename(), request.getContentType());
        System.out.println(request.toString());
        return image;
    }

    @GetMapping
    public List<Long> listIds(){
        return imageService.getAllIds();
    }
}
