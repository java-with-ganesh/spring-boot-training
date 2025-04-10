package com.i2i.service;

import com.i2i.dto.VitalSignDTO;
import com.i2i.mapper.VitalSignMapper;
import com.i2i.model.VitalSign;
import com.i2i.repository.VitalSignRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VitalSignService {
    @Autowired
    private VitalSignRepository vitalSignRepository;

    @Transactional
    public VitalSignDTO createVitalSign(VitalSignDTO vitalSignDTO) {
        log.info("creating vital sign for user {}",vitalSignDTO.getPatientMrnNumber());
        VitalSign vitalSign = VitalSignMapper.INSTANCE.toEntity(vitalSignDTO);

        // First save the vitalSign to generate ID
        vitalSign = vitalSignRepository.save(vitalSign);
        log.info("vital sign created for user {}",vitalSignDTO.getPatientMrnNumber());
        return VitalSignMapper.INSTANCE.toDTO(vitalSign);
    }

    public VitalSignDTO updateVitalSign(Long id, VitalSignDTO vitalSignDTO) {
        var vitalSign = vitalSignRepository.findById(id).orElseThrow();
        VitalSignMapper.INSTANCE.toEntityWithDefaults(vitalSignDTO, vitalSign);
        return VitalSignMapper.INSTANCE.toDTO(vitalSignRepository.save(vitalSign));
    }

    public VitalSignDTO getVitalSignById(Long id) {
        return vitalSignRepository.findById(id).map(VitalSignMapper.INSTANCE::toDTO).orElseThrow(RuntimeException::new);
    }

    public List<VitalSignDTO> getAllVitalSigns() {
        return vitalSignRepository.findAll().stream()
                .map(VitalSignMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public Page<VitalSignDTO> getAllVitalSigns(Pageable pageable) {
        return vitalSignRepository.findAll(pageable).map(VitalSignMapper.INSTANCE::toDTO);
    }

    public void deleteVitalSignById(Long id) {
        vitalSignRepository.deleteById(id);
    }
}
