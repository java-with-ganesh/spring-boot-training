package com.i2i.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.repository.AuditLogRepository;
import com.i2i.model.VitalSignAuditLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaListener {

    private final ObjectMapper objectMapper;

    private final AuditLogRepository auditLogRepository;

    @org.springframework.kafka.annotation.KafkaListener(topics = "audit-topic", groupId = "audit-group")
    public void consumeAuditMessages(ConsumerRecord<String, String> record) throws JsonProcessingException {
        log.info("Received Message" + record.key() + " value:" + record.value());
        var auditLog = objectMapper.readValue(record.value(), Map.class);
        var changeData = (List<Map<String, Object>>) auditLog.get("changeData");
        var attributes = (List<VitalSignAuditLog.Attribute>) changeData.stream().map(a -> VitalSignAuditLog.Attribute.builder()
                .name(a.get("name").toString())
                .oldValue(a.get("oldValue").toString())
                .newValue(a.get("newValue").toString())
                .build()).toList();
        var vitalSignAuditLog = VitalSignAuditLog
                .builder()
                .entityId(Long.valueOf(auditLog.get("entityId").toString()))
                .lastModified(Instant.parse(auditLog.get("modifiedDate").toString()))
                .modifyBy(auditLog.get("modifiedBy").toString())
                .action(auditLog.get("action").toString())
                .attributes(attributes)
                .build();
        log.info("Builded Audit Log {}", vitalSignAuditLog);
        auditLogRepository.save(vitalSignAuditLog);
    }
}
