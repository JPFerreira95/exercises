package com.exercises.mongotrial.service;

import com.exercises.mongotrial.collection.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    String save(Person person);

    List<Person> getPersonStartsWith(String name);

    void delete(String id);

    List<Person> getPersonByAge(Integer minAge, Integer maxAge);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();

    List<Document> getPopulationByCity();
}
