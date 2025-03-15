package com.example.jobmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler for handling exceptions across the whole application.
 * This class uses {@link ControllerAdvice} to handle exceptions globally.
 *
 * <p><strong>Handled Exceptions:</strong>
 * <ul>
 *     <li>{@link ResourceNotFoundException}</li>
 *     <li>{@link Exception}</li>
 * </ul>
 *
 * @version 1.0
 * @since 2023-10-01
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link ResourceNotFoundException} and returns a 404 Not Found response.
     *
     * @param ex      the exception to handle.
     * @param request the web request during which the exception occurred.
     * @return a {@link ResponseEntity} with a 404 status and the exception message.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles all other exceptions and returns a 500 Internal Server Error response.
     *
     * @param ex      the exception to handle.
     * @param request the web request during which the exception occurred.
     * @return a {@link ResponseEntity} with a 500 status and a generic error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}