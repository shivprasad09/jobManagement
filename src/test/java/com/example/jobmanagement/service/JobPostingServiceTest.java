/**
 * The {@code JobPostingServiceTest} class is a unit test class for testing the functionality
 * of the {@link JobPostingService} class. It verifies that the service methods correctly
 * interact with the {@link JobPostingRepository} and handle business logic as expected.
 *
 * <p><strong>Test Cases:</strong>
 * <ul>
 *     <li>{@link #testGetAllJobPostings()} - Tests retrieving all job postings.</li>
 *     <li>{@link #testGetJobPostingById()} - Tests retrieving a job posting by its ID.</li>
 *     <li>{@link #testGetJobPostingByIdNotFound()} - Tests handling a missing job posting.</li>
 *     <li>{@link #testCreateJobPosting()} - Tests creating a new job posting.</li>
 *     <li>{@link #testUpdateJobPosting()} - Tests updating an existing job posting.</li>
 *     <li>{@link #testDeleteJobPosting()} - Tests deleting a job posting by its ID.</li>
 * </ul>
 *
 * <p>This class uses Mockito to mock the {@link JobPostingRepository} and isolate the
 * service layer for testing.</p>
 *
 * @see JobPostingService
 * @see JobPostingRepository
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagement.service;

import com.example.jobmanagement.exception.ResourceNotFoundException;
import com.example.jobmanagement.model.JobPosting;
import com.example.jobmanagement.repository.JobPostingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobPostingServiceTest {

    @Mock
    private JobPostingRepository jobPostingRepository;

    @InjectMocks
    private JobPostingService jobPostingService;

    @Test
    void testGetAllJobPostings() {
        // Arrange
        JobPosting jobPosting1 = new JobPosting();
        jobPosting1.setTitle("Software Engineer");
        jobPosting1.setDescription("Develop and maintain software applications.");

        JobPosting jobPosting2 = new JobPosting();
        jobPosting2.setTitle("Data Scientist");
        jobPosting2.setDescription("Analyze and interpret complex data.");

        List<JobPosting> jobPostings = Arrays.asList(jobPosting1, jobPosting2);
        when(jobPostingRepository.findAll()).thenReturn(jobPostings);

        // Act
        List<JobPosting> result = jobPostingService.getAllJobPostings();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Software Engineer", result.get(0).getTitle());
        assertEquals("Data Scientist", result.get(1).getTitle());
        verify(jobPostingRepository, times(1)).findAll();
    }

    @Test
    void testGetJobPostingById() {
        // Arrange
        JobPosting jobPosting = new JobPosting();
        jobPosting.setId(1L);
        jobPosting.setTitle("Software Engineer");
        jobPosting.setDescription("Develop and maintain software applications.");

        when(jobPostingRepository.findById(1L)).thenReturn(Optional.of(jobPosting));

        // Act
        JobPosting result = jobPostingService.getJobPostingById(1L);

        // Assert
        assertEquals("Software Engineer", result.getTitle());
        assertEquals("Develop and maintain software applications.", result.getDescription());
        verify(jobPostingRepository, times(1)).findById(1L);
    }

    @Test
    void testGetJobPostingByIdNotFound() {
        // Arrange
        when(jobPostingRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> jobPostingService.getJobPostingById(1L));
        verify(jobPostingRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateJobPosting() {
        // Arrange
        JobPosting jobPosting = new JobPosting();
        jobPosting.setTitle("Software Engineer");
        jobPosting.setDescription("Develop and maintain software applications.");

        when(jobPostingRepository.save(jobPosting)).thenReturn(jobPosting);

        // Act
        JobPosting result = jobPostingService.createJobPosting(jobPosting);

        // Assert
        assertEquals("Software Engineer", result.getTitle());
        assertEquals("Develop and maintain software applications.", result.getDescription());
        verify(jobPostingRepository, times(1)).save(jobPosting);
    }

    @Test
    void testUpdateJobPosting() {
        // Arrange
        JobPosting existingJobPosting = new JobPosting();
        existingJobPosting.setId(1L);
        existingJobPosting.setTitle("Software Engineer");
        existingJobPosting.setDescription("Develop and maintain software applications.");

        JobPosting updatedJobPosting = new JobPosting();
        updatedJobPosting.setTitle("Senior Software Engineer");
        updatedJobPosting.setDescription("Lead development of software applications.");

        when(jobPostingRepository.findById(1L)).thenReturn(Optional.of(existingJobPosting));
        when(jobPostingRepository.save(existingJobPosting)).thenReturn(existingJobPosting);

        // Act
        JobPosting result = jobPostingService.updateJobPosting(1L, updatedJobPosting);

        // Assert
        assertEquals("Senior Software Engineer", result.getTitle());
        assertEquals("Lead development of software applications.", result.getDescription());
        verify(jobPostingRepository, times(1)).findById(1L);
        verify(jobPostingRepository, times(1)).save(existingJobPosting);
    }

    @Test
    void testDeleteJobPosting() {
        // Arrange
        doNothing().when(jobPostingRepository).deleteById(1L);

        // Act
        jobPostingService.deleteJobPosting(1L);

        // Assert
        verify(jobPostingRepository, times(1)).deleteById(1L);
    }
}