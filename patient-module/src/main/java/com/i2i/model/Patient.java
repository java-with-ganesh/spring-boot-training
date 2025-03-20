package com.i2i.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "medical_record_number", nullable = false, unique = true)
    private String medicalRecordNumber;

    @Column(name = "start_of_care_date", nullable = false)
    private LocalDate startOfCareDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "county")
    private String county;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "referral_info_id", referencedColumnName = "id")
    private ReferralInfo referralInfo;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diagnosis> diagnoses;
}
