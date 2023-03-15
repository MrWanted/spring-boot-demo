package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.Employee;
import com.example.springbootdemo.api.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
@Slf4j
@Data
@Tag(name = "Employee operations", description = "manage emloyees")
public class EmployeeController {
    private final EmployeeService service;

    @Operation(summary = "find all employees")
    @GetMapping("")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Employee.class)),
            }
            ) })
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "save the employee details", operationId = "isAlive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Employee.class)),
            }
            ) })
    @PostMapping("")
    public ResponseEntity save(@RequestBody Employee person) {
        log.info("Saving employee details...");
        return new ResponseEntity<>(service.save(person), HttpStatus.OK);
    }

    @Operation(summary = "update the employee details, if not found new employee will be created", operationId = "isAlive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Employee.class)),
            }
            ) })
    @PutMapping("/{id}")
    public Employee update(@RequestBody Employee person, @PathVariable Integer id) {
        log.info("updating person details...");
        return service.update(person, id);
    }

    @Operation(summary = "delete the investor details from the system", operationId = "isAlive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Employee.class)),
            }
            ) })
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) throws Exception {
        log.info("find employee details by id ...", id);
        return new ResponseEntity<>(service.findByID(id), HttpStatus.OK);
    }

    @Operation(summary = "delete the investor from the system", operationId = "isAlive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "404", description = "Employee not found, therefore could not be deleted"),
            @ApiResponse(responseCode = "200", description = "Successful deletion", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Employee.class)),
            }
            ) })
    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable("id") int id) throws Exception {
        log.info("deleting a person by id ...", id);
        service.deleteById(id);
    }
}
