package com.i2i.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientPublisher {

    private static final Logger log = LoggerFactory.getLogger(PatientPublisher.class);
    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.queue}")
    private String queue;

    @Value("${app.rabbitmq.routing-key}")
    private String routingKey;

    public void publishPatient(PatientDTO patientDTO) {
        try {
            log.info("publishing message to rabbit MQ exchange {} routing key {} started", exchange, routingKey);
            rabbitTemplate.convertAndSend(exchange, routingKey, objectMapper.writeValueAsString(patientDTO));
            log.info("publishing message to rabbit MQ completed");
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error in parsing json" + e.getMessage());
        }
    }

}
