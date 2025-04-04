package com.i2i.controller;

import com.i2i.model.Patient;
import com.i2i.repository.PatientSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("patients/")
@RequiredArgsConstructor
public class PatientSearchController {

    private final PatientSearchRepository patientSearchRepository;

    @GetMapping("search")
    public List<Patient> search(@RequestParam String query) {
        return patientSearchRepository
                .findByFirstNameContainingOrLastNameContainingOrMrNumberContaining(query, query, query);
    }
}
