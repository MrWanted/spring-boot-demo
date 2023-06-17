package com.example.springbootdemo.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String error;
    private String message;
    private List<String> messages;
    public ErrorResponse(String error, String message){
        this.error = error;
        this.message = message;
    }
    public ErrorResponse(String error, List<String> messages){
        this.error = error;
        this.messages = messages;
    }
}



