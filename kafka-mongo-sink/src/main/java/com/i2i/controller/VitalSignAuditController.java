package com.i2i.controller;

import com.i2i.model.VitalSignAuditLog;
import com.i2i.service.VitalSignAuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class VitalSignAuditController {

    private final VitalSignAuditLogService service;

    // 📌 Get Logs by Date Range and User
    @GetMapping("/user")
    public List<VitalSignAuditLog> getLogsByUser(
            @RequestParam String startDate,
            @RequestParam String  endDate,
            @RequestParam String user) {
        var startTime = Instant.parse(startDate);
        var endTime = Instant.parse(endDate);
        return service.getLogsByDateRangeAndUser(startTime, endTime, user);
    }

    // 📌 Get Logs by Date Range and Entity Type
    @GetMapping("/entity")
    public List<VitalSignAuditLog> getLogsByEntity(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam String entity) {
        return service.getLogsByDateRangeAndEntity(startDate, endDate, entity);
    }

    // 📌 Get All Logs for a Specific Entity ID
    @GetMapping("/entityId/{entityId}")
    public List<VitalSignAuditLog> getLogsByEntityId(@PathVariable long entityId) {
        return service.getLogsByEntityId(entityId);
    }
}
