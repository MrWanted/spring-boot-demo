package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.Project;
import com.example.springbootdemo.api.service.ProjectService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/project")
@Slf4j
@Data
public class ProjectController {
    private final ProjectService service;

    @GetMapping("")
    public ResponseEntity<List<Project>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Project project) {
        log.info("Saving department details...");
        return new ResponseEntity<>(service.save(project), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Project update(@RequestBody Project project, @PathVariable Integer id) {
        log.info("updating project details...");
        return service.update(project, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Integer id) throws Exception {
        log.info("find a project details by id ...", id);
        return new ResponseEntity<>(service.findByID(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable("id") int id) throws Exception {
        log.info("deleting a department by id ...", id);
        service.deleteById(id);
    }
}
