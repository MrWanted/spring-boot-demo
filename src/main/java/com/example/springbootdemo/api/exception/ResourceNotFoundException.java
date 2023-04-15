package com.example.springbootdemo.api.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ApplicationException{
    private Integer id;
    public ResourceNotFoundException(String message) {
        super(message);
    }

}