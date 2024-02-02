package com.exercises.mongotrial.service;

import com.exercises.mongotrial.collection.Person;
import com.exercises.mongotrial.enumeration.query.PersonField;
import com.exercises.mongotrial.repository.PersonRepository;
import com.exercises.mongotrial.util.SearchBuilder;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Person service.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Person person) {
        return personRepository.save(person).getPersonId();
    }

    @Override
    public List<Person> getPersonStartsWith(String name) {
        return personRepository.findByFirstNameStartsWith(name);
    }

    @Override
    public void delete(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getPersonByAge(Integer minAge, Integer maxAge) {
        return personRepository.findPersonsBetweenAge(minAge, maxAge);
    }

    @Override
    public Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable) {

        SearchBuilder searchBuilder = new SearchBuilder(pageable, mongoTemplate, Person.class);
        Page<?> results = searchBuilder.addCaseInsensitiveCriteria(PersonField.FIRST_NAME, name)
                .addBetweenClosedIntervalCriteria(PersonField.AGE, minAge, maxAge)
                .addIsCriteria(PersonField.CITY, city)
                .getResults();

        return (Page<Person>) results;
    }

    /**
     * Use of aggregation functions to get the oldest person by city
     *
     * @return List of documents aggregate by the oldest person of each city
     */
    @Override
    public List<Document> getOldestPersonByCity() {

        // Unwind operation
        // Flatten the addresses
        UnwindOperation unwindOperation = Aggregation.unwind("addresses");

        // Sort operation by age
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.DESC, "age");

        // Group operation by city
        GroupOperation groupOperation = Aggregation.group("addresses.city")
                .first(Aggregation.ROOT)
                .as("oldestPerson");

        // Pass operations to aggregation
        Aggregation aggregation = Aggregation.newAggregation(unwindOperation, sortOperation, groupOperation);

        // Apply aggregation
        List<Document> person = mongoTemplate.aggregate(aggregation, Person.class, Document.class).getMappedResults();

        return person;
    }

    @Override
    public List<Document> getPopulationByCity() {

        // Unwind operation
        UnwindOperation unwindOperation = Aggregation.unwind("addresses");

        // Grouping operation
        GroupOperation groupOperation = Aggregation
                .group("addresses.city")
                .count()
                .as("populationCount");

        // Sort operation
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.DESC, "populationCount");

        // Pojection (what data we need to return)
        ProjectionOperation projectionOperation = Aggregation
                .project()
                .andExpression("_id").as("city")
                .andExpression("populationCount").as("count")
                .andExclude("_id");

        Aggregation aggregation = Aggregation.newAggregation(unwindOperation, groupOperation, sortOperation, projectionOperation);

        List<Document> documents = mongoTemplate.aggregate(aggregation, Person.class, Document.class).getMappedResults();

        return documents;
    }

}
