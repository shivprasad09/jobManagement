/**
 * The {@code JobPostingTest} class is a JUnit test class for testing the functionality
 * of the {@link JobPosting} class. It verifies that the job posting entity correctly initializes
 * and manages its fields and relationships.
 *
 * <p><strong>Test Cases:</strong>
 * <ul>
 *     <li>{@link #testJobPosting()} - Tests the initialization and management of all fields
 *     and relationships in the {@link JobPosting} class, including ID, title, description,
 *     location, requirements, posting date, and candidate applications.</li>
 * </ul>
 *
 * @see JobPosting
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagementapplication.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobPostingTest {

    @Test
    void testJobPosting() {
        // Create a JobPosting instance
        JobPosting jobPosting = new JobPosting();

        // Test ID
        jobPosting.setId(1L);
        assertEquals(1L, jobPosting.getId());

        // Test Title
        jobPosting.setTitle("Software Engineer");
        assertEquals("Software Engineer", jobPosting.getTitle());

        // Test Description
        jobPosting.setDescription("Develop and maintain software applications.");
        assertEquals("Develop and maintain software applications.", jobPosting.getDescription());

        // Test Location
        jobPosting.setLocation("Remote");
        assertEquals("Remote", jobPosting.getLocation());

        // Test Requirements
        jobPosting.setRequirements("Bachelor's degree in Computer Science, 3+ years of experience.");
        assertEquals("Bachelor's degree in Computer Science, 3+ years of experience.", jobPosting.getRequirements());

        // Test Posting Date
        LocalDate postingDate = LocalDate.of(2023, 10, 1);
        jobPosting.setPostingDate(postingDate);
        assertEquals(postingDate, jobPosting.getPostingDate());

        // Test Applications Relationship
        CandidateApplication application1 = new CandidateApplication();
        application1.setId(1L);
        CandidateApplication application2 = new CandidateApplication();
        application2.setId(2L);
        List<CandidateApplication> applications = Arrays.asList(application1, application2);
        jobPosting.setApplications(applications);
        assertEquals(applications, jobPosting.getApplications());
        assertEquals(2, jobPosting.getApplications().size());
        assertEquals(1L, jobPosting.getApplications().get(0).getId());
        assertEquals(2L, jobPosting.getApplications().get(1).getId());
    }
}