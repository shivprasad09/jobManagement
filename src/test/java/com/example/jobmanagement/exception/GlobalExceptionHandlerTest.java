package com.example.jobmanagement.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Unit tests for {@link GlobalExceptionHandler}.
 * This class verifies the functionality of the global exception handling methods.
 *
 * <p><strong>Tested Methods:</strong>
 * <ul>
 *     <li>{@link GlobalExceptionHandler#handleResourceNotFoundException(ResourceNotFoundException, WebRequest)}</li>
 *     <li>{@link GlobalExceptionHandler#handleGlobalException(Exception, WebRequest)}</li>
 * </ul>
 *
 * @version 1.0
 * @since 2023-10-01
 */
@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;
    private WebRequest webRequest;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
        webRequest = mock(WebRequest.class);
    }

    /**
     * Tests the handling of {@link ResourceNotFoundException}.
     * Verifies that the response status is 404 Not Found and the message is correct.
     */
    @Test
    public void testHandleResourceNotFoundException() {
        // Arrange
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");

        // Act
        ResponseEntity<String> response = globalExceptionHandler.handleResourceNotFoundException(exception, webRequest);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isEqualTo("Resource not found");
    }

    /**
     * Tests the handling of generic exceptions.
     * Verifies that the response status is 500 Internal Server Error and the message is generic.
     */
    @Test
    public void testHandleGlobalException() {
        // Arrange
        Exception exception = new Exception("Unexpected error");

        // Act
        ResponseEntity<String> response = globalExceptionHandler.handleGlobalException(exception, webRequest);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isEqualTo("An unexpected error occurred");
    }
}