package com.i2i.mapper;

import com.i2i.dto.PatientDTO;
import com.i2i.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    PatientDTO toDTO(Patient patient);
    Patient toEntity(PatientDTO patientDTO);
}
