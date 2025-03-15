package com.example.jobmanagement.repository;

import com.example.jobmanagement.model.CandidateApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for {@link CandidateApplicationRepository}.
 * This class contains unit tests to verify the functionality of the {@link CandidateApplicationRepository} class.
 * It uses Spring Data JPA's {@link DataJpaTest} annotation to configure an in-memory database and
 * {@link TestEntityManager} to manage entities during tests.
 *
 * <p>This class tests the following repository methods:
 * <ul>
 *     <li>{@link CandidateApplicationRepository#save(Object)}</li>
 *     <li>{@link CandidateApplicationRepository#findById(Object)}</li>
 *     <li>{@link CandidateApplicationRepository#findAll()}</li>
 *     <li>{@link CandidateApplicationRepository#deleteById(Object)}</li>
 *     <li>{@link CandidateApplicationRepository#save(Object)} (for updates)</li>
 * </ul>
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@DataJpaTest
public class CandidateApplicationRepositoryTest {

    /**
     * The {@link TestEntityManager} instance used to persist and manage entities during tests.
     * This is automatically injected by Spring.
     */
    @Autowired
    private TestEntityManager entityManager;

    /**
     * The repository under test.
     * This is automatically injected by Spring.
     */
    @Autowired
    private CandidateApplicationRepository candidateApplicationRepository;

    /**
     * Tests the {@link CandidateApplicationRepository#save(Object)} method.
     * Verifies that a new {@link CandidateApplication} can be saved and that the saved entity has an auto-generated ID.
     */
    @Test
    public void testSaveCandidateApplication() {
        // Create a new CandidateApplication
        CandidateApplication application = new CandidateApplication();
        application.setName("John Doe");
        application.setEmail("john.doe@example.com");
        application.setResumePath("/resumes/john_doe.pdf");
        application.setCoverLetterPath("/cover-letters/john_doe.pdf");
        application.setStatus("Applied");

        // Save the application
        CandidateApplication savedApplication = candidateApplicationRepository.save(application);

        // Verify the saved application
        assertThat(savedApplication).isNotNull();
        assertThat(savedApplication.getId()).isNotNull();
        assertThat(savedApplication.getName()).isEqualTo("John Doe");
    }

    /**
     * Tests the {@link CandidateApplicationRepository#findById(Object)} method.
     * Verifies that a {@link CandidateApplication} can be retrieved by its ID.
     */
    @Test
    public void testFindCandidateApplicationById() {
        // Create and persist a CandidateApplication
        CandidateApplication application = new CandidateApplication();
        application.setName("Jane Doe");
        application.setEmail("jane.doe@example.com");
        entityManager.persist(application);

        // Retrieve the application by ID
        Optional<CandidateApplication> foundApplication = candidateApplicationRepository.findById(application.getId());

        // Verify the retrieved application
        assertThat(foundApplication).isPresent();
        assertThat(foundApplication.get().getName()).isEqualTo("Jane Doe");
    }

    /**
     * Tests the {@link CandidateApplicationRepository#findAll()} method.
     * Verifies that all {@link CandidateApplication} entities can be retrieved.
     */
    @Test
    public void testFindAllCandidateApplications() {
        // Create and persist multiple CandidateApplications
        CandidateApplication application1 = new CandidateApplication();
        application1.setName("Alice");
        application1.setEmail("alice@example.com");
        entityManager.persist(application1);

        CandidateApplication application2 = new CandidateApplication();
        application2.setName("Bob");
        application2.setEmail("bob@example.com");
        entityManager.persist(application2);

        // Retrieve all applications
        List<CandidateApplication> applications = candidateApplicationRepository.findAll();

        // Verify the retrieved applications
        assertThat(applications).hasSize(2);
        assertThat(applications).extracting(CandidateApplication::getName).containsExactlyInAnyOrder("Alice", "Bob");
    }

    /**
     * Tests the {@link CandidateApplicationRepository#deleteById(Object)} method.
     * Verifies that a {@link CandidateApplication} can be deleted by its ID.
     */
    @Test
    public void testDeleteCandidateApplicationById() {
        // Create and persist a CandidateApplication
        CandidateApplication application = new CandidateApplication();
        application.setName("Charlie");
        application.setEmail("charlie@example.com");
        entityManager.persist(application);

        // Delete the application by ID
        candidateApplicationRepository.deleteById(application.getId());

        // Verify the application is deleted
        Optional<CandidateApplication> deletedApplication = candidateApplicationRepository.findById(application.getId());
        assertThat(deletedApplication).isNotPresent();
    }

    /**
     * Tests the {@link CandidateApplicationRepository#save(Object)} method for updating an existing entity.
     * Verifies that a {@link CandidateApplication} can be updated and the changes are persisted.
     */
    @Test
    public void testUpdateCandidateApplication() {
        // Create and persist a CandidateApplication
        CandidateApplication application = new CandidateApplication();
        application.setName("David");
        application.setEmail("david@example.com");
        entityManager.persist(application);

        // Update the application
        application.setName("David Smith");
        CandidateApplication updatedApplication = candidateApplicationRepository.save(application);

        // Verify the updated application
        assertThat(updatedApplication.getName()).isEqualTo("David Smith");
    }
}