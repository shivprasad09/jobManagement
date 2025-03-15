package com.example.jobmanagement.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a job posting entity in the system.
 * This class defines the structure of a job posting, including its title, description,
 * location, requirements, posting date, and associated candidate applications.
 *
 * <p>Each job posting is uniquely identified by an auto-generated ID and can have multiple
 * candidate applications associated with it. The relationship between a job posting and its
 * applications is managed using a one-to-many mapping.</p>
 *
 * <p>This class is annotated with JPA annotations to enable persistence in a relational database.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@Entity
public class JobPosting {

    /**
     * The unique identifier for the job posting.
     * This field is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the job posting.
     * This field represents the name or title of the job position.
     */
    private String title;

    /**
     * The description of the job posting.
     * This field provides detailed information about the job responsibilities and expectations.
     */
    private String description;

    /**
     * The location of the job posting.
     * This field specifies where the job is located, such as a city, state, or remote.
     */
    private String location;

    /**
     * The requirements for the job posting.
     * This field lists the qualifications, skills, and experience required for the job.
     */
    private String requirements;

    /**
     * The date when the job posting was created.
     * This field stores the date the job posting was made available.
     */
    private LocalDate postingDate;

    /**
     * The list of candidate applications associated with this job posting.
     * This field represents a one-to-many relationship with the {@link CandidateApplication} entity.
     * It is mapped by the "jobPosting" field in the {@link CandidateApplication} class.
     * Cascade operations are applied to ensure that operations on this entity are propagated to its applications.
     */
    @OneToMany(mappedBy = "jobPosting", cascade = CascadeType.ALL)
    private List<CandidateApplication> applications;

    public JobPosting(long l, String softwareEngineer, String s) {
    }

    public JobPosting() {

    }

    /**
     * Returns the unique identifier of the job posting.
     *
     * @return the ID of the job posting.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the job posting.
     *
     * @param id the ID to set for the job posting.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the title of the job posting.
     *
     * @return the title of the job posting.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the job posting.
     *
     * @param title the title to set for the job posting.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the description of the job posting.
     *
     * @return the description of the job posting.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the job posting.
     *
     * @param description the description to set for the job posting.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the location of the job posting.
     *
     * @return the location of the job posting.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the job posting.
     *
     * @param location the location to set for the job posting.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the requirements for the job posting.
     *
     * @return the requirements for the job posting.
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Sets the requirements for the job posting.
     *
     * @param requirements the requirements to set for the job posting.
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Returns the posting date of the job posting.
     *
     * @return the posting date of the job posting.
     */
    public LocalDate getPostingDate() {
        return postingDate;
    }

    /**
     * Sets the posting date of the job posting.
     *
     * @param postingDate the posting date to set for the job posting.
     */
    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    /**
     * Returns the list of candidate applications associated with this job posting.
     *
     * @return the list of candidate applications.
     */
    public List<CandidateApplication> getApplications() {
        return applications;
    }

    /**
     * Sets the list of candidate applications associated with this job posting.
     *
     * @param applications the list of candidate applications to set.
     */
    public void setApplications(List<CandidateApplication> applications) {
        this.applications = applications;
    }
}