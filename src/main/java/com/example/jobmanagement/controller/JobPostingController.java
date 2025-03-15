/**
 * The {@code JobPostingController} class is a Spring REST controller that handles HTTP requests
 * related to {@link JobPosting} entities. It provides endpoints for performing CRUD operations
 * on job postings, such as retrieving, creating, updating, and deleting job postings.
 *
 * <p>This controller maps all requests to the base URL {@code /api/job-postings} and delegates
 * the business logic to the {@link JobPostingService} class.
 *
 * <p><strong>Endpoints:</strong>
 * <ul>
 *     <li>{@code GET /api/job-postings} - Retrieves a list of all job postings.</li>
 *     <li>{@code GET /api/job-postings/{id}} - Retrieves a specific job posting by its ID.</li>
 *     <li>{@code POST /api/job-postings} - Creates a new job posting.</li>
 *     <li>{@code PUT /api/job-postings/{id}} - Updates an existing job posting by its ID.</li>
 *     <li>{@code DELETE /api/job-postings/{id}} - Deletes a job posting by its ID.</li>
 * </ul>
 *
 * <p><strong>Example Usage:</strong>
 * <pre>
 * {@code
 * // Retrieve all job postings
 * GET /api/job-postings
 *
 * // Retrieve a job posting by ID
 * GET /api/job-postings/1
 *
 * // Create a new job posting
 * POST /api/job-postings
 * {
 *     "title": "Software Engineer",
 *     "description": "Develop and maintain software applications."
 * }
 *
 * // Update an existing job posting
 * PUT /api/job-postings/1
 * {
 *     "title": "Senior Software Engineer",
 *     "description": "Lead development of software applications."
 * }
 *
 * // Delete a job posting
 * DELETE /api/job-postings/1
 * }
 * </pre>
 *
 * @see JobPosting
 * @see JobPostingService
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagement.controller;

import com.example.jobmanagement.model.JobPosting;
import com.example.jobmanagement.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing job postings.
 */
@RestController
@RequestMapping("/api/job-postings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    /**
     * Retrieves a list of all job postings.
     *
     * @return a list of {@link JobPosting} objects.
     */
    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        return jobPostingService.getAllJobPostings();
    }

    /**
     * Retrieves a specific job posting by its ID.
     *
     * @param id the ID of the job posting to retrieve.
     * @return the {@link JobPosting} object with the specified ID.
     */
    @GetMapping("/{id}")
    public JobPosting getJobPostingById(@PathVariable Long id) {
        return jobPostingService.getJobPostingById(id);
    }

    /**
     * Creates a new job posting.
     *
     * @param jobPosting the {@link JobPosting} object to create.
     * @return the created {@link JobPosting} object.
     */
    @PostMapping
    public JobPosting createJobPosting(@RequestBody JobPosting jobPosting) {
        return jobPostingService.createJobPosting(jobPosting);
    }

    /**
     * Updates an existing job posting by its ID.
     *
     * @param id the ID of the job posting to update.
     * @param jobPostingDetails the updated {@link JobPosting} object.
     * @return the updated {@link JobPosting} object.
     */
    @PutMapping("/{id}")
    public JobPosting updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPostingDetails) {
        return jobPostingService.updateJobPosting(id, jobPostingDetails);
    }

    /**
     * Deletes a job posting by its ID.
     *
     * @param id the ID of the job posting to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
    }
}