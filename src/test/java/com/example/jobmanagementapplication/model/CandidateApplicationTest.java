/**
 * The {@code CandidateApplicationTest} class is a JUnit test class for testing the functionality
 * of the {@link CandidateApplication} class. It verifies that the candidate application entity
 * correctly initializes and manages its fields and relationships.
 *
 * <p><strong>Test Cases:</strong>
 * <ul>
 *     <li>{@link #testCandidateApplication()} - Tests the initialization and management of all fields
 *     and relationships in the {@link CandidateApplication} class, including ID, name, email, resume path,
 * cover letter path, status, job posting, and interview.</li>
 * </ul>
 *
 * @see CandidateApplication
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagementapplication.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CandidateApplicationTest {

    @Test
    void testCandidateApplication() {
        // Create a CandidateApplication instance
        CandidateApplication candidateApplication = new CandidateApplication();

        // Test ID
        candidateApplication.setId(1L);
        assertEquals(1L, candidateApplication.getId());

        // Test Name
        candidateApplication.setName("John Doe");
        assertEquals("John Doe", candidateApplication.getName());

        // Test Email
        candidateApplication.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", candidateApplication.getEmail());

        // Test Resume Path
        candidateApplication.setResumePath("/resumes/john_doe.pdf");
        assertEquals("/resumes/john_doe.pdf", candidateApplication.getResumePath());

        // Test Cover Letter Path
        candidateApplication.setCoverLetterPath("/cover-letters/john_doe.pdf");
        assertEquals("/cover-letters/john_doe.pdf", candidateApplication.getCoverLetterPath());

        // Test Status
        candidateApplication.setStatus("Submitted");
        assertEquals("Submitted", candidateApplication.getStatus());

        // Test Job Posting Relationship
        JobPosting jobPosting = new JobPosting();
        jobPosting.setId(1L);
        candidateApplication.setJobPosting(jobPosting);
        assertEquals(jobPosting, candidateApplication.getJobPosting());
        assertEquals(1L, candidateApplication.getJobPosting().getId());

        // Test Interview Relationship
        Interview interview = new Interview();
        interview.setId(1L);
        candidateApplication.setInterview(interview);
        assertEquals(interview, candidateApplication.getInterview());
        assertEquals(1L, candidateApplication.getInterview().getId());
    }
}