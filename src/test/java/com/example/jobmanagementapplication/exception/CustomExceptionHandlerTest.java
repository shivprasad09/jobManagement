/**
 * The {@code CustomExceptionHandlerTest} class is a JUnit test class for testing the functionality
 * of the {@link CustomExceptionHandler} class. It verifies that the global exception handler
 * correctly handles exceptions and returns the appropriate HTTP response.
 *
 * <p><strong>Test Cases:</strong>
 * <ul>
 *     <li>{@link #testHandleResourceNotFoundException()} - Tests the handling of a {@link ResourceNotFoundException}
 *     and verifies that an HTTP 404 (Not Found) response is returned with the correct error message.</li>
 * </ul>
 *
 * @see CustomExceptionHandler
 * @see ResourceNotFoundException
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagementapplication.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomExceptionHandlerTest {

    private final CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();

    /**
     * Tests the {@link CustomExceptionHandler#handleResourceNotFoundException(ResourceNotFoundException)} method.
     * Verifies that the method returns an HTTP 404 (Not Found) response with the correct error message
     * when a {@link ResourceNotFoundException} is thrown.
     */
    @Test
    void testHandleResourceNotFoundException() {
        // Arrange
        String errorMessage = "Job posting not found with id: 1";
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Act
        ResponseEntity<String> response = customExceptionHandler.handleResourceNotFoundException(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }
}