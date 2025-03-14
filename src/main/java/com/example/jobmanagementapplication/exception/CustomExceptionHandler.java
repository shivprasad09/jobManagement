/**
 * The {@code CustomExceptionHandler} class is a global exception handler that centralizes
 * the handling of exceptions across the application. It uses Spring's {@link ControllerAdvice}
 * annotation to provide a global exception handling mechanism for all controllers.
 *
 * <p>This class defines methods to handle specific exceptions, such as {@link ResourceNotFoundException},
 * and returns an appropriate HTTP response with a meaningful error message and status code.
 *
 * <p><strong>Exception Handling:</strong>
 * <ul>
 *     <li>{@link ResourceNotFoundException} - Handles cases where a requested resource is not found.
 *     Returns an HTTP 404 (Not Found) status code with the exception message.</li>
 * </ul>
 *
 * <p><strong>Example Usage:</strong>
 * <pre>
 * {@code
 * // When a resource is not found, the exception is automatically handled by this class.
 * // For example, if a job posting is not found, the following response is returned:
 * // HTTP Status: 404 Not Found
 * // Response Body: "Job posting not found with id: 1"
 * }
 * </pre>
 *
 * @see ControllerAdvice
 * @see ExceptionHandler
 * @see ResourceNotFoundException
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagementapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handles {@link ResourceNotFoundException} by returning an HTTP 404 (Not Found) response
     * with the exception message as the response body.
     *
     * @param ex The {@link ResourceNotFoundException} instance containing the error message.
     * @return A {@link ResponseEntity} with the exception message and HTTP 404 status.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}