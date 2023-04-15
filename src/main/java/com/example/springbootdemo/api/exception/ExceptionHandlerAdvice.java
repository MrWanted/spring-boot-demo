package com.example.springbootdemo.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.net.URISyntaxException;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handlePostNotFoundException(ResourceNotFoundException exception) throws URISyntaxException {
        log.error("Resource not found", exception);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        problemDetail.setProperty("postId", exception.getId());
        //URL below hardcoded for illustration purposes
        problemDetail.setType(new URI("http://localhost:8080/rest/api/investor/problems/person-not-found"));

        return problemDetail;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetail handleAllUncaughtException(Exception exception, WebRequest request) throws URISyntaxException {
        log.error("An error occurred", exception);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        problemDetail.setProperty("postId", exception.getMessage());
        //URL below hardcoded for illustration purposes
        problemDetail.setType(new URI("http://localhost:8080/rest/api/investor/problems/person-not-found"));

        return problemDetail;
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleInvalidException(InvalidRequestException exception, WebRequest request) throws URISyntaxException {
        log.error("An error occurred", exception);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problemDetail.setProperty("postId", exception.getMessage());
        //URL below hardcoded for illustration purposes
        problemDetail.setType(new URI("http://localhost:8080/rest/api/investor/problems/person-not-found"));

        return problemDetail;
    }

    /*** use this code if you want to user error codes in your application
     * @ExceptionHandler(ResourceNotFoundException.class)
     *     public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
     *         ErrorResponse errorResponse = new ErrorResponse(1001, ex.getMessage());
     *         return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
     *     }
     */
}