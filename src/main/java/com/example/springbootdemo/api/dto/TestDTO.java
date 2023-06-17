package com.example.springbootdemo.api.dto;

import jakarta.validation.constraints.NotBlank;

public class TestDTO {
    @NotBlank(message = "Name is required")
    private String name;
   // @NotBlank(message = "lastName is required")
    private String lastName;
    private String contactNumber;
}
