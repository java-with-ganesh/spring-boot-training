package com.i2i.repository;

import com.i2i.model.Patient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientSearchRepository extends ElasticsearchRepository<Patient, Long> {
    List<Patient> findByFirstNameContainingOrLastNameContainingOrMrNumberContaining(String firstName, String lastName, String mrNumber);

    List<Patient> findByDateOfBirth(LocalDate dob);
}
