package com.example.jobmanagementapplication.controller;

import com.example.jobmanagementapplication.model.JobPosting;
import com.example.jobmanagementapplication.service.JobPostingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link JobPostingController}.
 * This class verifies the functionality of the REST API endpoints exposed by the JobPostingController.
 * It uses Mockito to mock the {@link JobPostingService} and focuses on testing the controller layer in isolation.
 *
 * <p><strong>Tested Methods:</strong>
 * <ul>
 *     <li>{@link JobPostingController#getAllJobPostings()}</li>
 *     <li>{@link JobPostingController#getJobPostingById(Long)}</li>
 *     <li>{@link JobPostingController#createJobPosting(JobPosting)}</li>
 *     <li>{@link JobPostingController#updateJobPosting(Long, JobPosting)}</li>
 *     <li>{@link JobPostingController#deleteJobPosting(Long)}</li>
 * </ul>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
class JobPostingControllerTest {

    @Mock
    private JobPostingService jobPostingService;

    @InjectMocks
    private JobPostingController jobPostingController;

    /**
     * Initializes mock objects before each test method execution.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the GET /api/job-postings endpoint.
     * Verifies that the controller returns all job postings from the service layer.
     */
    @Test
    void testGetAllJobPostings() {
        // Arrange
        JobPosting job1 = new JobPosting(1L, "Developer", "Backend development");
        JobPosting job2 = new JobPosting(2L, "Architect", "System design");
        List<JobPosting> mockJobs = Arrays.asList(job1, job2);

        when(jobPostingService.getAllJobPostings()).thenReturn(mockJobs);

        // Act
        List<JobPosting> result = jobPostingController.getAllJobPostings();

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(job1, job2);
        verify(jobPostingService, times(1)).getAllJobPostings();
    }

    /**
     * Tests the GET /api/job-postings/{id} endpoint.
     * Verifies that the controller returns the correct job posting when a valid ID is provided.
     */
    @Test
    void testGetJobPostingById() {
        // Arrange
        JobPosting mockJob = new JobPosting(1L, "Developer", "Backend development");
        when(jobPostingService.getJobPostingById(1L)).thenReturn(mockJob);

        // Act
        JobPosting result = jobPostingController.getJobPostingById(1L);

        // Assert
        assertThat(result).isEqualTo(mockJob);
        verify(jobPostingService, times(1)).getJobPostingById(1L);
    }

    /**
     * Tests the POST /api/job-postings endpoint.
     * Verifies that the controller properly creates and returns a new job posting.
     */
    @Test
    void testCreateJobPosting() {
        // Arrange
        JobPosting newJob = new JobPosting(null, "New Job", "Job description");
        JobPosting savedJob = new JobPosting(1L, "New Job", "Job description");

        when(jobPostingService.createJobPosting(newJob)).thenReturn(savedJob);

        // Act
        JobPosting result = jobPostingController.createJobPosting(newJob);

        // Assert
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("New Job");
        verify(jobPostingService, times(1)).createJobPosting(newJob);
    }

    /**
     * Tests the PUT /api/job-postings/{id} endpoint.
     * Verifies that the controller properly updates and returns an existing job posting.
     */
    @Test
    void testUpdateJobPosting() {
        // Arrange
        JobPosting existingJob = new JobPosting(1L, "Old Title", "Old Description");
        JobPosting updatedDetails = new JobPosting(null, "New Title", "New Description");
        JobPosting updatedJob = new JobPosting(1L, "New Title", "New Description");

        when(jobPostingService.updateJobPosting(1L, updatedDetails)).thenReturn(updatedJob);

        // Act
        JobPosting result = jobPostingController.updateJobPosting(1L, updatedDetails);

        // Assert
        assertThat(result.getTitle()).isEqualTo("New Title");
        assertThat(result.getDescription()).isEqualTo("New Description");
        verify(jobPostingService, times(1)).updateJobPosting(1L, updatedDetails);
    }

    /**
     * Tests the DELETE /api/job-postings/{id} endpoint.
     * Verifies that the controller properly delegates the deletion request to the service layer.
     */
    @Test
    void testDeleteJobPosting() {
        // Act
        jobPostingController.deleteJobPosting(1L);

        // Assert
        verify(jobPostingService, times(1)).deleteJobPosting(1L);
    }
}