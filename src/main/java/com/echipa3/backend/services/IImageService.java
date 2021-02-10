package com.echipa3.backend.services;

import com.echipa3.backend.entities.Image;

import java.util.List;

public interface IImageService {

    Image saveImage(byte[] imageBytes, String imageName, String imageContentType);

    List<Long> getAllIds();

}
