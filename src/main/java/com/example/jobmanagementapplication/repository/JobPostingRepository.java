/**
 * The {@code JobPostingRepository} interface provides the mechanism for storage, retrieval,
 * and search operations on {@link JobPosting} entities. It extends the {@link JpaRepository}
 * interface, which provides JPA-specific methods out-of-the-box for performing CRUD operations
 * and pagination.
 *
 * <p>This repository is specifically designed to manage {@link JobPosting} entities, where each
 * entity represents a job posting in the system. The primary key type for the {@link JobPosting}
 * entity is {@link Long}.
 *
 * <p>By extending {@link JpaRepository}, this interface inherits methods such as:
 * <ul>
 *     <li>{@code save(S entity)} - Saves a given entity.</li>
 *     <li>{@code findById(ID id)} - Retrieves an entity by its primary key.</li>
 *     <li>{@code findAll()} - Returns all entities.</li>
 *     <li>{@code deleteById(ID id)} - Deletes an entity by its primary key.</li>
 *     <li>{@code count()} - Returns the total number of entities.</li>
 * </ul>
 *
 * <p>This interface can be extended to include custom query methods using Spring Data JPA's
 * method naming conventions or by annotating methods with {@code @Query}.
 *
 * <p><strong>Example Usage:</strong>
 * <pre>
 * {@code
 * // Autowire the repository
 * @Autowired
 * private JobPostingRepository jobPostingRepository;
 *
 * // Save a new job posting
 * JobPosting jobPosting = new JobPosting();
 * jobPosting.setTitle("Software Engineer");
 * jobPosting.setDescription("Develop and maintain software applications.");
 * jobPostingRepository.save(jobPosting);
 *
 * // Retrieve a job posting by ID
 * Optional<JobPosting> retrievedJobPosting = jobPostingRepository.findById(1L);
 *
 * // Retrieve all job postings
 * List<JobPosting> allJobPostings = jobPostingRepository.findAll();
 *
 * // Delete a job posting by ID
 * jobPostingRepository.deleteById(1L);
 * }
 * </pre>
 *
 * @see JpaRepository
 * @see JobPosting
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagementapplication.repository;

import com.example.jobmanagementapplication.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}