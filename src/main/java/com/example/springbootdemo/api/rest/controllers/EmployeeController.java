package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.Employee;
import com.example.springbootdemo.api.service.EmployeeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/api/person")
@Slf4j
@Data
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping("")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Employee person) {
        log.info("Saving person details...");
        return new ResponseEntity<>(service.save(person), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Employee update(@RequestBody Employee person, @PathVariable Integer id) {
        log.info("updating person details...");
        return service.update(person, id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) throws Exception {
        log.info("find a person details by id ...", id);
        return new ResponseEntity<>(service.findByID(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable("id") int id) throws Exception {
        log.info("deleting a person by id ...", id);
        service.deleteById(id);
    }
}
