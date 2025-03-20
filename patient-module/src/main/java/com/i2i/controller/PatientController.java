package com.i2i.controller;

import com.i2i.dto.PatientDTO;
import com.i2i.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.createPatient(patientDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<PatientDTO>> getAllPatients(Pageable pageable) {
        return ResponseEntity.ok(patientService.getAllPatients(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
