package com.i2i.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.dto.PatientDto;
import com.i2i.model.Patient;
import com.i2i.repository.PatientSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQListener {

    private final PatientSearchRepository patientSearchRepository;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "patient-queue")
    public void consume(String message) throws JsonProcessingException {
        System.out.println("Received message: " + message);
        var patientDto = objectMapper.readValue(message, PatientDto.class);
        var patient = Patient.builder()
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
                .dateOfBirth(patientDto.getDateOfBirth())
                .mrNumber(patientDto.getMrNumber())
                .build();
        patientSearchRepository.save(patient);
    }

}