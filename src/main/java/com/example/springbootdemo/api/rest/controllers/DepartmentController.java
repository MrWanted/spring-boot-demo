package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.Department;
import com.example.springbootdemo.api.service.DepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/department")
@Slf4j
@Data
public class DepartmentController {
    private final DepartmentService service;

    @GetMapping("")
    public ResponseEntity<List<Department>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Department department) {
        log.info("Saving department details...");
        return new ResponseEntity<>(service.save(department), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public Department update(@RequestBody Department department, @PathVariable Integer id) {
        log.info("updating department details...");
        return service.update(department, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Integer id) throws Exception {
        log.info("find a department details by id ...", id);
        return new ResponseEntity<>(service.findByID(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable("id") int id) throws Exception {
        log.info("deleting a department by id ...", id);
        service.deleteById(id);
    }
}
