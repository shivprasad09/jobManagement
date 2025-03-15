/**
 * The {@code ResourceNotFoundException} class is a custom runtime exception that is thrown
 * when a requested resource is not found in the system. This exception is typically used
 * in scenarios where an operation attempts to access or manipulate a resource that does
 * not exist, such as a job posting, candidate application, or interview.
 *
 * <p>This exception extends the {@link RuntimeException} class, making it an unchecked exception.
 * It provides a constructor to initialize the exception with a custom error message.
 *
 * <p><strong>Example Usage:</strong>
 * <pre>
 * {@code
 * // Throw the exception when a resource is not found
 * if (jobPosting == null) {
 *     throw new ResourceNotFoundException("Job posting not found with id: " + id);
 * }
 * }
 * </pre>
 *
 * @see RuntimeException
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagement.exception;

public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code ResourceNotFoundException} with the specified detail message.
     *
     * @param message The detail message that describes the reason for the exception.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}