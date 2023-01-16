package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.Person;
import com.example.springbootdemo.api.service.PersonService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/person")
@Slf4j
@Data
public class PersonController {
    private final PersonService service;

    @GetMapping("")
    public ResponseEntity<List<Person>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Person person) {
        log.info("Saving person details...");
        return new ResponseEntity<>(service.save(person), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Person update(@RequestBody Person person, @PathVariable Integer id) {
        log.info("updating person details...");
        return service.update(person, id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) throws Exception {
        log.info("find a person details by id ...", id);
        return new ResponseEntity<>(service.findByID(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable("id") int id) throws Exception {
        log.info("deleting a person by id ...", id);
        service.deleteById(id);
    }
}
