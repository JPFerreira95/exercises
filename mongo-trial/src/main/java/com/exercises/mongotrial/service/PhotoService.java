package com.exercises.mongotrial.service;

import com.exercises.mongotrial.collection.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

    String addPhoto(String originalFilename, MultipartFile image);

    Photo getPhoto(String id);
}
