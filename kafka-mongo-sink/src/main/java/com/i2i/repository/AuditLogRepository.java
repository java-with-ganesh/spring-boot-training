package com.i2i.repository;

import com.i2i.model.VitalSignAuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditLogRepository extends MongoRepository<VitalSignAuditLog, String> {

    List<VitalSignAuditLog> findByLastModifiedBetweenAndModifyBy(Instant startDate, Instant endDate, String modifyBy);

    List<VitalSignAuditLog> findByLastModifiedBetweenAndEntity(LocalDateTime startDate, LocalDateTime endDate, String entity);

    @Query("{ entityId: ?0 }")
    List<VitalSignAuditLog> findByEntityId(long entityId);

    @Query("{ action: ?0 }")
    List<VitalSignAuditLog> findByAction(String action);
}

