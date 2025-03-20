package com.i2i.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diagnoses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Diagnosis extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
