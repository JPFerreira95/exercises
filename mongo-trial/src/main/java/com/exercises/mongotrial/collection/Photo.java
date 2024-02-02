package com.exercises.mongotrial.collection;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "photo")
public class Photo {

    @Id
    private String id;
    private String title;
    private Binary photo;
}
