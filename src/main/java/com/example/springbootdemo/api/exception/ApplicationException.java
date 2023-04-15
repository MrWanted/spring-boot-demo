package com.example.springbootdemo.api.exception;

/****
 * exception hierarchy to provide a more organized and consistent approach to handling exceptions.
 * This can also help to reduce code duplication and improve maintainability.
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
