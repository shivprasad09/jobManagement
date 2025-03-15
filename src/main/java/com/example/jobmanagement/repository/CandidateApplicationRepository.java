/**
 * The {@code CandidateApplicationRepository} interface provides the mechanism for storage,
 * retrieval, and search operations on {@link CandidateApplication} entities. It extends the
 * {@link JpaRepository} interface, which provides JPA-specific methods out-of-the-box for
 * performing CRUD operations and pagination.
 *
 * <p>This repository is specifically designed to manage {@link CandidateApplication} entities,
 * where each entity represents a candidate's application for a job posting in the system.
 * The primary key type for the {@link CandidateApplication} entity is {@link Long}.
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
 * private CandidateApplicationRepository candidateApplicationRepository;
 *
 * // Save a new candidate application
 * CandidateApplication application = new CandidateApplication();
 * application.setCandidateName("John Doe");
 * application.setJobPostingId(1L);
 * candidateApplicationRepository.save(application);
 *
 * // Retrieve a candidate application by ID
 * Optional<CandidateApplication> retrievedApplication = candidateApplicationRepository.findById(1L);
 *
 * // Retrieve all candidate applications
 * List<CandidateApplication> allApplications = candidateApplicationRepository.findAll();
 *
 * // Delete a candidate application by ID
 * candidateApplicationRepository.deleteById(1L);
 * }
 * </pre>
 *
 * @see JpaRepository
 * @see CandidateApplication
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagement.repository;

import com.example.jobmanagement.model.CandidateApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateApplicationRepository extends JpaRepository<CandidateApplication, Long> {
}