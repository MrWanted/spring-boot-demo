package com.example.springbootdemo.api.rest.controllers;

import com.example.springbootdemo.api.dto.TestDTO;
import com.example.springbootdemo.api.exception.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestControllerTest {

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private TestController testController;

    @Test
    public void createPerson_withValidationErrors_returnsBadRequestResponse() {
        // Mocking validation errors
        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError("testDTO", "lastName", "lastName is required"));
        fieldErrors.add(new FieldError("testDTO", "name", "name is required"));

        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);

        // Perform the request
        ResponseEntity<Object> response = testController.createPerson(new TestDTO(), bindingResult);

        // Verify the response
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertEquals("Bad request", errorResponse.getError());
        assertEquals(2, errorResponse.getMessages().size());
        assertEquals("lastName is required", errorResponse.getMessages().get(0));
        assertEquals("name is required", errorResponse.getMessages().get(1));
    }

    @Test
    public void createPerson_withNoValidationErrors_returnsCreatedResponse() {
        when(bindingResult.hasErrors()).thenReturn(false);

        // Perform the request
        ResponseEntity<Object> response = testController.createPerson(new TestDTO(), bindingResult);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Object created successfully", response.getBody());
    }

    @Test
    public void logBindingErrors_logsEachError() {
        FieldError fieldError1 = new FieldError("testDTO", "lastName", "lastName is required");
        FieldError fieldError2 = new FieldError("testDTO", "name", "name is required");

        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.getAllErrors()).thenReturn(List.of(fieldError1, fieldError2));

        testController.createPerson(new TestDTO(), bindingResult);

        // Verify that the error messages are logged
        Mockito.verify(testController, Mockito.times(1)).logBindingErrors(bindingResult);
    }
}

