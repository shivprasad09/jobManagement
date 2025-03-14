package com.example.jobmanagementapplication.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents an interview entity in the system.
 * This class defines the structure of an interview, including its date, time, location,
 * interviewer, and the associated candidate application.
 *
 * <p>Each interview is uniquely identified by an auto-generated ID and is associated with
 * a specific candidate application. This class is used to schedule and manage interviews
 * as part of the hiring process.</p>
 *
 * <p>This class is annotated with JPA annotations to enable persistence in a relational database.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@Entity
public class Interview {

    /**
     * The unique identifier for the interview.
     * This field is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The date of the interview.
     * This field represents the scheduled date for the interview.
     */
    private LocalDate date;

    /**
     * The time of the interview.
     * This field represents the scheduled time for the interview.
     */
    private LocalTime time;

    /**
     * The location of the interview.
     * This field specifies where the interview will take place, such as a physical address or a virtual meeting link.
     */
    private String location;

    /**
     * The name of the interviewer.
     * This field represents the person who will conduct the interview.
     */
    private String interviewer;

    /**
     * The candidate application associated with this interview.
     * This field represents a one-to-one relationship with the {@link CandidateApplication} entity.
     * It is joined using the "candidate_application_id" column in the database.
     */
    @OneToOne
    @JoinColumn(name = "candidate_application_id")
    private CandidateApplication candidateApplication;

    /**
     * Returns the unique identifier of the interview.
     *
     * @return the ID of the interview.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the interview.
     *
     * @param id the ID to set for the interview.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the date of the interview.
     *
     * @return the date of the interview.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the interview.
     *
     * @param date the date to set for the interview.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the time of the interview.
     *
     * @return the time of the interview.
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Sets the time of the interview.
     *
     * @param time the time to set for the interview.
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Returns the location of the interview.
     *
     * @return the location of the interview.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the interview.
     *
     * @param location the location to set for the interview.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the name of the interviewer.
     *
     * @return the name of the interviewer.
     */
    public String getInterviewer() {
        return interviewer;
    }

    /**
     * Sets the name of the interviewer.
     *
     * @param interviewer the name of the interviewer to set.
     */
    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    /**
     * Returns the candidate application associated with this interview.
     *
     * @return the associated candidate application.
     */
    public CandidateApplication getCandidateApplication() {
        return candidateApplication;
    }

    /**
     * Sets the candidate application associated with this interview.
     *
     * @param candidateApplication the candidate application to associate with this interview.
     */
    public void setCandidateApplication(CandidateApplication candidateApplication) {
        this.candidateApplication = candidateApplication;
    }
}