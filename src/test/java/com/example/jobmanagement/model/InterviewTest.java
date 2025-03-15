/**
 * The {@code InterviewTest} class is a JUnit test class for testing the functionality
 * of the {@link Interview} class. It verifies that the interview entity correctly initializes
 * and manages its fields and relationships.
 *
 * <p><strong>Test Cases:</strong>
 * <ul>
 *     <li>{@link #testInterview()} - Tests the initialization and management of all fields
 *     and relationships in the {@link Interview} class, including ID, date, time, location,
 *     interviewer, and candidate application.</li>
 * </ul>
 *
 * @see Interview
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagement.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterviewTest {

    @Test
    void testInterview() {
        // Create an Interview instance
        Interview interview = new Interview();

        // Test ID
        interview.setId(1L);
        assertEquals(1L, interview.getId());

        // Test Date
        LocalDate date = LocalDate.of(2023, 10, 15);
        interview.setDate(date);
        assertEquals(date, interview.getDate());

        // Test Time
        LocalTime time = LocalTime.of(14, 30);
        interview.setTime(time);
        assertEquals(time, interview.getTime());

        // Test Location
        interview.setLocation("Virtual Meeting Room");
        assertEquals("Virtual Meeting Room", interview.getLocation());

        // Test Interviewer
        interview.setInterviewer("Jane Doe");
        assertEquals("Jane Doe", interview.getInterviewer());

        // Test CandidateApplication Relationship
        CandidateApplication candidateApplication = new CandidateApplication();
        candidateApplication.setId(1L);
        interview.setCandidateApplication(candidateApplication);
        assertEquals(candidateApplication, interview.getCandidateApplication());
        assertEquals(1L, interview.getCandidateApplication().getId());
    }
}