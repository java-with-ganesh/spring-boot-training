package com.i2i.service;

import com.i2i.dto.PatientDTO;
import com.i2i.mapper.PatientMapper;
import com.i2i.model.Patient;
import com.i2i.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = PatientMapper.INSTANCE.toEntity(patientDTO);

        // First save the patient to generate ID
        patient = patientRepository.save(patient);

        // Now generate the Medical Record Number (MRN)
        patient.setMedicalRecordNumber(generateMRN(patient.getId()));

        // Save again to update the MRN
        patient = patientRepository.save(patient);

        return PatientMapper.INSTANCE.toDTO(patient);
    }

    private String generateMRN(Long id) {
        return String.format("MRN_%06d", id);
    }

    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = PatientMapper.INSTANCE.toEntity(patientDTO);
        patient.setId(id);
        return PatientMapper.INSTANCE.toDTO(patientRepository.save(patient));
    }

    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id).map(PatientMapper.INSTANCE::toDTO).orElse(null);
    }

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public Page<PatientDTO> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable).map(PatientMapper.INSTANCE::toDTO);
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}
