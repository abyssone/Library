package com.example.library.services;

import com.example.library.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ImageService {

    //TODO: обработка, если файл на обработку пришел пустым
    static Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
