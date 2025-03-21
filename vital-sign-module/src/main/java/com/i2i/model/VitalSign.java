package com.i2i.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vital_signs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VitalSign extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pulse")
    private String pulse;

    @Column(name = "temperature", nullable = false)
    private String temperature;

    @Column(name = "respirations", nullable = false)
    private String respirations;

    @Column(name = "blood_sugar", nullable = false)
    private String bloodSugar;

    @Column(name = "weight", nullable = false)
    private String weight;

    @Column(name = "height", nullable = false)
    private String height;

    @Column(name = "spo2", nullable = false)
    private String spo2;

    @Column(name = "pt_inr")
    private String ptInr;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_mrn_number", nullable = false)
    private String patientMrnNumber;

    @Column(name = "documented_by", nullable = false)
    private String documentedBy;
}
