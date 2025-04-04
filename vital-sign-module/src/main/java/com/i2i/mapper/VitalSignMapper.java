package com.i2i.mapper;

import com.i2i.dto.VitalSignDTO;
import com.i2i.model.VitalSign;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VitalSignMapper {
    VitalSignMapper INSTANCE = Mappers.getMapper(VitalSignMapper.class);

    VitalSignDTO toDTO(VitalSign vitalSign);

    VitalSign toEntity(VitalSignDTO vitalSignDTO);

    @BeanMapping(nullValuePropertyMappingStrategy= NullValuePropertyMappingStrategy.IGNORE)
    void toEntityWithDefaults(VitalSignDTO vitalSignDTO,@MappingTarget VitalSign vitalSign );
}
