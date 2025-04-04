package com.i2i.service;

import com.i2i.model.VitalSignAuditLog;
import com.i2i.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VitalSignAuditLogService {

    private final AuditLogRepository repository;

    public List<VitalSignAuditLog> getLogsByDateRangeAndUser(Instant startDate, Instant endDate, String user) {
        return repository.findByLastModifiedBetweenAndModifyBy(startDate, endDate, user);
    }

    public List<VitalSignAuditLog> getLogsByDateRangeAndEntity(LocalDateTime startDate, LocalDateTime endDate, String entity) {
        return repository.findByLastModifiedBetweenAndEntity(startDate, endDate, entity);
    }

    public List<VitalSignAuditLog> getLogsByEntityId(long entityId) {
       return repository.findByEntityId(entityId);
    }
}
