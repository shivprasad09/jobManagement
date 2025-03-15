package com.example.jobmanagement.model;

import jakarta.persistence.*;

/**
 * Represents a candidate application entity in the system.
 * This class defines the structure of a candidate application, including the candidate's name, email,
 * resume path, cover letter path, application status, and associated job posting and interview details.
 *
 * <p>Each candidate application is uniquely identified by an auto-generated ID and is associated with
 * a specific job posting. Additionally, it may have an interview scheduled as part of the hiring process.</p>
 *
 * <p>This class is annotated with JPA annotations to enable persistence in a relational database.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@Entity
public class CandidateApplication {

    /**
     * The unique identifier for the candidate application.
     * This field is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the candidate.
     * This field represents the full name of the candidate applying for the job.
     */
    private String name;

    /**
     * The email address of the candidate.
     * This field is used to contact the candidate regarding their application.
     */
    private String email;

    /**
     * The file path to the candidate's resume.
     * This field stores the location of the resume file uploaded by the candidate.
     */
    private String resumePath;

    /**
     * The file path to the candidate's cover letter.
     * This field stores the location of the cover letter file uploaded by the candidate.
     */
    private String coverLetterPath;

    /**
     * The status of the candidate application.
     * This field represents the current stage of the application, such as "Submitted", "Under Review", "Interview Scheduled", etc.
     */
    private String status;

    /**
     * The job posting associated with this candidate application.
     * This field represents a many-to-one relationship with the {@link JobPosting} entity.
     * It is joined using the "job_posting_id" column in the database.
     */
    @ManyToOne
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;

    /**
     * The interview scheduled for this candidate application.
     * This field represents a one-to-one relationship with the {@link Interview} entity.
     * It is mapped by the "candidateApplication" field in the {@link Interview} class.
     * Cascade operations are applied to ensure that operations on this entity are propagated to the interview.
     */
    @OneToOne(mappedBy = "candidateApplication", cascade = CascadeType.ALL)
    private Interview interview;

    /**
     * Returns the unique identifier of the candidate application.
     *
     * @return the ID of the candidate application.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the candidate application.
     *
     * @param id the ID to set for the candidate application.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the candidate.
     *
     * @return the name of the candidate.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the candidate.
     *
     * @param name the name to set for the candidate.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the email address of the candidate.
     *
     * @return the email address of the candidate.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the candidate.
     *
     * @param email the email address to set for the candidate.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the file path to the candidate's resume.
     *
     * @return the resume file path.
     */
    public String getResumePath() {
        return resumePath;
    }

    /**
     * Sets the file path to the candidate's resume.
     *
     * @param resumePath the resume file path to set.
     */
    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    /**
     * Returns the file path to the candidate's cover letter.
     *
     * @return the cover letter file path.
     */
    public String getCoverLetterPath() {
        return coverLetterPath;
    }

    /**
     * Sets the file path to the candidate's cover letter.
     *
     * @param coverLetterPath the cover letter file path to set.
     */
    public void setCoverLetterPath(String coverLetterPath) {
        this.coverLetterPath = coverLetterPath;
    }

    /**
     * Returns the status of the candidate application.
     *
     * @return the status of the application.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the candidate application.
     *
     * @param status the status to set for the application.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the job posting associated with this candidate application.
     *
     * @return the associated job posting.
     */
    public JobPosting getJobPosting() {
        return jobPosting;
    }

    /**
     * Sets the job posting associated with this candidate application.
     *
     * @param jobPosting the job posting to associate with this application.
     */
    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    /**
     * Returns the interview scheduled for this candidate application.
     *
     * @return the associated interview.
     */
    public Interview getInterview() {
        return interview;
    }

    /**
     * Sets the interview scheduled for this candidate application.
     *
     * @param interview the interview to associate with this application.
     */
    public void setInterview(Interview interview) {
        this.interview = interview;
    }

}