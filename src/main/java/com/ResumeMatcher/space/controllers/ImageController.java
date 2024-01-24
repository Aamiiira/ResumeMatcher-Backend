package com.ResumeMatcher.space.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ResumeMatcher.space.entities.Image;
import com.ResumeMatcher.space.repositories.ImageRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "check")

public class ImageController {

	@Autowired
    ImageRepository imageRepository;

    @PostMapping("/upload")
    public Image uplaodImage(@RequestParam("myFile") MultipartFile file) throws IOException {

        Image img = new Image(file.getOriginalFilename(),file.getContentType(),file.getBytes() );


        final Image savedImage = imageRepository.save(img);


        System.out.println("Image saved");


        return savedImage;


    }
}
