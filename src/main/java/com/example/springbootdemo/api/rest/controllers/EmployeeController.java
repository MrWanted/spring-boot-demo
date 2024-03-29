package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.entity.Employee;
import com.example.springbootdemo.api.service.EmployeeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = "Employee operations", description = "manage employees")
public class EmployeeController {
    private final EmployeeService service;

    @Operation(summary = "find all employees",
               description = "description goes here")
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
    @PostMapping("")
    public ResponseEntity save(@RequestBody  @Valid Employee person) {
        try {
            log.info("Saving employee details...");
            return new ResponseEntity<>(service.save(person), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error saving employee details: {}", e.getMessage());
            return new ResponseEntity<>("Error saving employee details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "update the employee details, if not found new employee will be created", operationId = "isAlive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Employee.class)),
            }
            ) })
    @Parameters({
            @Parameter(name = "id", description = "ID", example = "1")
    })
    @PutMapping("/{id}")
    public Employee update(@RequestBody @Valid Employee person, @PathVariable Integer id) {
        log.info("updating person details...");
        return service.update(person, id);
    }

    @Operation(summary = "retrieves employee details", operationId = "isAlive",
            description = "This API searches for an employee with unique Id, "
                    + "Once the employee is found, will return a response with employee details such as  "
                    + "name, surname , banking details etc."
                    + "If the employee is not found, appropriate error message will be returned.")

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) throws Exception {
        log.info("find employee details by id ...", id);
        return new ResponseEntity<>(service.findByID(id), HttpStatus.OK);
    }

    @Operation(summary = "delete the investor from the system", operationId = "isAlive")
    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable("id") int id) throws Exception {
        log.info("deleting a person by id ...", id);
        service.deleteById(id);
    }
}
