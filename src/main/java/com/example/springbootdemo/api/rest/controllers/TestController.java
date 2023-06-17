package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.dto.TestDTO;
import com.example.springbootdemo.api.exception.ErrorResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@Slf4j
public class TestController {
    @PostMapping("/dto")
    public ResponseEntity<Object> createPerson(@Valid @RequestBody TestDTO testDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if (fieldErrors.size() == 1) {
                // If there is only one error, return it as the error message
                FieldError fieldError = fieldErrors.get(0);
                ErrorResponse errorResponse = new ErrorResponse("Bad request", fieldError.getDefaultMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            } else {
                // If there are multiple errors, collect all the error messages
                List<String> errors = new ArrayList<>();
                for (FieldError fieldError : fieldErrors) {
                    errors.add(fieldError.getDefaultMessage());
                }
                ErrorResponse errorResponse = new ErrorResponse("Bad request", errors);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        }

        String responseMessage = "Object created successfully";
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    public void logBindingErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> log.error(error.getDefaultMessage()));
        }
    }
}
