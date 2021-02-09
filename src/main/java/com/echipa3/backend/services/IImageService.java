package com.echipa3.backend.services;

import com.echipa3.backend.entities.Image;

public interface IImageService {

    Image saveImage(byte[] imageBytes, String imageName, String imageContentType);

}
