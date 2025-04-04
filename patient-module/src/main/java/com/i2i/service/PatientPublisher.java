package com.i2i.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientPublisher {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.queue}")
    private String queue;

    @Value("${app.rabbitmq.routing-key}")
    private String routingKey;

    public void publishPatient(PatientDTO patientDTO)  {
        try {
            rabbitTemplate.convertAndSend(exchange,routingKey,objectMapper.writeValueAsString(patientDTO));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
