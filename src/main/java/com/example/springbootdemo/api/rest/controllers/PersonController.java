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
    public ResponseEntity save(Person person) {
        log.info("Saving person details...");
        return new ResponseEntity<>(service.save(person), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable Integer id) {
        log.info("find investor details by id ...", id);
        return new ResponseEntity<>(service.findByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePersonByID(@PathVariable("id") int id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}