/**
 * The {@code InterviewRepository} interface provides the mechanism for storage, retrieval,
 * and search operations on {@link Interview} entities. It extends the {@link JpaRepository}
 * interface, which provides JPA-specific methods out-of-the-box for performing CRUD operations
 * and pagination.
 *
 * <p>This repository is specifically designed to manage {@link Interview} entities, where each
 * entity represents an interview scheduled for a candidate's job application in the system.
 * The primary key type for the {@link Interview} entity is {@link Long}.
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
 * private InterviewRepository interviewRepository;
 *
 * // Save a new interview
 * Interview interview = new Interview();
 * interview.setCandidateApplicationId(1L);
 * interview.setInterviewDate(LocalDateTime.now());
 * interview.setLocation("Virtual");
 * interviewRepository.save(interview);
 *
 * // Retrieve an interview by ID
 * Optional<Interview> retrievedInterview = interviewRepository.findById(1L);
 *
 * // Retrieve all interviews
 * List<Interview> allInterviews = interviewRepository.findAll();
 *
 * // Delete an interview by ID
 * interviewRepository.deleteById(1L);
 * }
 * </pre>
 *
 * @see JpaRepository
 * @see Interview
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
package com.example.jobmanagementapplication.repository;

import com.example.jobmanagementapplication.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}