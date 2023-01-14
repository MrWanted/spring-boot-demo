package com.example.springbootdemo.api.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundExeption extends RuntimeException{
    private Integer id;

    public PersonNotFoundExeption(){
        super();
    }

    public PersonNotFoundExeption(Exception e){
        super(e);
    }
    public PersonNotFoundExeption(String message){
        super(message);
    }
    public PersonNotFoundExeption(Integer id) {
        this.id = id;
    }
}