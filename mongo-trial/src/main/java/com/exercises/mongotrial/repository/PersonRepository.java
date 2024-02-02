package com.exercises.mongotrial.repository;

import com.exercises.mongotrial.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameStartsWith(String name);

    // List<Person> findByAgeBetween(Integer min, Integer max); // Works the same as the method bellow
    @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1 } }", // age > ?0 & age < ?1
            fields = "{addresses: 0}") // get all the fields except "addresses"
    List<Person> findPersonsBetweenAge(Integer min, Integer max);
}