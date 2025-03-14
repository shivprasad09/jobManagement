package com.example.jobmanagementapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The {@code JobManagementApplication} class is the main entry point for the Job Management Application.
 * It is a Spring Boot application that initializes and runs the application context.
 *
 * <p>This class is annotated with {@link SpringBootApplication}, which combines the following annotations:
 * <ul>
 *     <li>{@code @Configuration} - Marks the class as a source of bean definitions.</li>
 *     <li>{@code @EnableAutoConfiguration} - Enables Spring Boot's auto-configuration mechanism.</li>
 *     <li>{@code @ComponentScan} - Scans for components, configurations, and services in the specified package.</li>
 * </ul>
 *
 * <p>The {@code main} method uses {@link SpringApplication#run} to bootstrap the application.
 *
 * <p><strong>Example Usage:</strong>
 * <pre>
 * {@code
 * // Run the application
 * JobManagementApplication.main(new String[] {});
 * }
 * </pre>
 *
 * @see SpringBootApplication
 * @see SpringApplication
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@SpringBootApplication
public class JobManagementApplicationTest {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(JobManagementApplicationTest.class, args);
    }
}