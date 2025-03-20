package com.i2i.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "referral_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ReferralInfo extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "referrer_name", nullable = false)
    private String referrerName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;
}
