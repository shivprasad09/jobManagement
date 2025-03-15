package com.example.jobmanagement.service;

import com.example.jobmanagement.exception.ResourceNotFoundException;
import com.example.jobmanagement.model.JobPosting;
import com.example.jobmanagement.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service class for managing job postings.
 * This class provides methods to perform CRUD (Create, Read, Update, Delete) operations
 * on job postings using the {@link JobPostingRepository}.
 *
 * <p>This class is annotated with {@link Service} to indicate that it is a service component
 * in the Spring framework and is eligible for dependency injection.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@Service
public class JobPostingService {

    /**
     * The repository for managing job posting data.
     * This field is automatically injected by Spring using the {@link Autowired} annotation.
     */
    @Autowired
    private JobPostingRepository jobPostingRepository;

    /**
     * Retrieves all job postings from the database.
     *
     * @return a list of all job postings.
     */
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    /**
     * Retrieves a job posting by its unique identifier.
     *
     * @param id the ID of the job posting to retrieve.
     * @return the job posting with the specified ID.
     * @throws ResourceNotFoundException if no job posting is found with the given ID.
     */
    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobPosting not found"));
    }

    /**
     * Creates a new job posting and saves it to the database.
     *
     * @param jobPosting the job posting to create.
     * @return the created job posting.
     */
    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    /**
     * Updates an existing job posting with new details.
     *
     * @param id the ID of the job posting to update.
     * @param jobPostingDetails the new details to update the job posting with.
     * @return the updated job posting.
     * @throws ResourceNotFoundException if no job posting is found with the given ID.
     */
    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
        JobPosting jobPosting = getJobPostingById(id);
        jobPosting.setTitle(jobPostingDetails.getTitle());
        jobPosting.setDescription(jobPostingDetails.getDescription());
        jobPosting.setLocation(jobPostingDetails.getLocation());
        jobPosting.setRequirements(jobPostingDetails.getRequirements());
        return jobPostingRepository.save(jobPosting);
    }

    /**
     * Deletes a job posting by its unique identifier.
     *
     * @param id the ID of the job posting to delete.
     */
    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }
}