package com.exercises.mongotrial.service;

import com.exercises.mongotrial.collection.Photo;
import com.exercises.mongotrial.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public String addPhoto(String originalFilename, MultipartFile image) {

        Photo photo = new Photo();
        photo.setTitle(originalFilename);
        try {
            photo.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return photoRepository.save(photo).getId();
    }

    @Override
    public Photo getPhoto(String id) {
        return photoRepository.findById(id).orElseThrow(() -> new RuntimeException("Photo with id=" + id + " not found."));
    }


}
