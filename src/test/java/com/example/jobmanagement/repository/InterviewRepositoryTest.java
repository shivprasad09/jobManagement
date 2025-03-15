package com.example.jobmanagement.repository;

import com.example.jobmanagement.model.Interview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class InterviewRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InterviewRepository interviewRepository;

    @Test
    public void testSaveInterview() {
        Interview interview = new Interview();
        interview.setCandidateName("John Doe");
        interview.setDate(LocalDate.of(2023, 10, 1));
        Interview savedInterview = interviewRepository.save(interview);
        assertThat(savedInterview).isNotNull();
        assertThat(savedInterview.getId()).isNotNull();
    }

    @Test
    public void testFindInterviewById() {
        Interview interview = new Interview();
        interview.setCandidateName("John Doe");
        interview.setDate(LocalDate.of(2023, 10, 1));
        entityManager.persist(interview);
        Optional<Interview> foundInterview = interviewRepository.findById(interview.getId());
        assertThat(foundInterview).isPresent();
        assertThat(foundInterview.get().getCandidateName()).isEqualTo("John Doe");
    }

    @Test
    public void testFindAllInterviews() {
        Interview interview1 = new Interview();
        interview1.setCandidateName("Alice");
        interview1.setDate(LocalDate.of(2023, 10, 2));
        entityManager.persist(interview1);

        Interview interview2 = new Interview();
        interview2.setCandidateName("Bob");
        interview2.setDate(LocalDate.of(2023, 10, 3));
        entityManager.persist(interview2);

        List<Interview> interviews = interviewRepository.findAll();
        assertThat(interviews).hasSize(2);
        assertThat(interviews).extracting(Interview::getCandidateName).containsExactlyInAnyOrder("Alice", "Bob");
    }

    @Test
    public void testDeleteInterviewById() {
        Interview interview = new Interview();
        interview.setCandidateName("John Doe");
        interview.setDate(LocalDate.of(2023, 10, 1));
        entityManager.persist(interview);
        interviewRepository.deleteById(interview.getId());
        Optional<Interview> deletedInterview = interviewRepository.findById(interview.getId());
        assertThat(deletedInterview).isNotPresent();
    }

    @Test
    public void testUpdateInterview() {
        Interview interview = new Interview();
        interview.setCandidateName("John Doe");
        interview.setDate(LocalDate.of(2023, 10, 1));
        entityManager.persist(interview);
        interview.setCandidateName("David Smith");
        Interview updatedInterview = interviewRepository.save(interview);
        assertThat(updatedInterview.getCandidateName()).isEqualTo("David Smith");
    }
}