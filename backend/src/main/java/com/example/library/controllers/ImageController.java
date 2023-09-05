package com.example.library.controllers;

import com.example.library.models.Image;
import com.example.library.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;

    @GetMapping("images/{id}")
    public ResponseEntity<?> getImageById(@PathVariable Long id) throws UnsupportedEncodingException {
        Image image = imageRepository.findById(id).orElse(null);
        if(image == null) {
            return ResponseEntity.ok()
                    .header("filename", "null")
                    .body("");
        } else {
            return ResponseEntity.ok()
                    .header("fileName", URLEncoder.encode(image.getOriginalFileName(), "UTF-8") )
                    .contentType(MediaType.valueOf(image.getContentType()))
                    .contentLength(image.getSize())
                    .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
        }
    }
}
