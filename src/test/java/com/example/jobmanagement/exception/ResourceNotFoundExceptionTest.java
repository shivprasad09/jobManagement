/**
 * The {@code ResourceNotFoundExceptionTest} class is a JUnit test class for testing the functionality
 * of the {@link ResourceNotFoundException} class. It verifies that the custom runtime exception
 * is correctly initialized with the provided error message.
 *
 * <p><strong>Test Cases:</strong>
 * <ul>
 *     <li>{@link #testResourceNotFoundException()} - Tests the constructor of {@link ResourceNotFoundException}
 *     and verifies that the exception message is correctly set.</li>
 * </ul>
 *
 * @see ResourceNotFoundException
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceNotFoundExceptionTest {

    /**
     * Tests the {@link ResourceNotFoundException#ResourceNotFoundException(String)} constructor.
     * Verifies that the exception is correctly initialized with the provided error message.
     */
    @Test
    void testResourceNotFoundException() {
        // Arrange
        String errorMessage = "Job posting not found with id: 1";

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage());
    }
}