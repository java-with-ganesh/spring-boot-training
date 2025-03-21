package com.i2i.repository;

import com.i2i.model.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {
}
