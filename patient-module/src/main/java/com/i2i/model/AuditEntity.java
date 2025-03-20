package com.i2i.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AuditEntity {
    @Column(name = "created", nullable = false, updatable = false)
    private LocalDate created;
    
    @Column(name = "updated")
    private LocalDate updated;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "updated_by")
    private String updatedBy;
    
    @Column(name = "row_version")
    private Long rowVersion;
}
