package com.echipa3.backend.controllers;

import com.echipa3.backend.entities.Image;
import com.echipa3.backend.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @PostMapping
    public Image saveImage(@RequestParam("image") MultipartFile request) throws IOException {
        return imageService.saveImage(request.getBytes(), request.getOriginalFilename(), request.getContentType());
    }
}
