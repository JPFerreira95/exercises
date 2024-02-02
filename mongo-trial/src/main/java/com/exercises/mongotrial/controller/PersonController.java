package com.exercises.mongotrial.controller;

import com.exercises.mongotrial.collection.Person;
import com.exercises.mongotrial.service.PersonService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Person person) {
        String id = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping
    public List<Person> getPersonStartWith(@RequestParam("name") String name) {
        return personService.getPersonStartsWith(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        personService.delete(id);
    }

    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam Integer minAge,
                                       @RequestParam Integer maxAge) {
        return personService.getPersonByAge(minAge, maxAge);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        return personService.search(name, minAge, maxAge, city, pageable);
    }

    @GetMapping("/oldestPerson")
    public List<Document> getOldestPerson() {
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/populationByCity")
    public List<Document> getPopulationByCity() {
        return personService.getPopulationByCity();
    }

}
