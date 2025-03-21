package com.i2i.controller;

import com.i2i.dto.VitalSignDTO;
import com.i2i.service.VitalSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitalSigns")
public class VitalSignController {
    @Autowired
    private VitalSignService vitalSignService;

    @PostMapping
    public ResponseEntity<VitalSignDTO> createVitalSign(@RequestBody VitalSignDTO vitalSignDTO) {
        return ResponseEntity.ok(vitalSignService.createVitalSign(vitalSignDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VitalSignDTO> updateVitalSign(@PathVariable Long id, @RequestBody VitalSignDTO vitalSignDTO) {
        return ResponseEntity.ok(vitalSignService.updateVitalSign(id, vitalSignDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VitalSignDTO> getVitalSignById(@PathVariable Long id) {
        return ResponseEntity.ok(vitalSignService.getVitalSignById(id));
    }

    @GetMapping
    public ResponseEntity<List<VitalSignDTO>> getAllVitalSigns() {
        return ResponseEntity.ok(vitalSignService.getAllVitalSigns());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<VitalSignDTO>> getAllVitalSigns(Pageable pageable) {
        return ResponseEntity.ok(vitalSignService.getAllVitalSigns(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVitalSignById(@PathVariable Long id) {
        vitalSignService.deleteVitalSignById(id);
        return ResponseEntity.noContent().build();
    }
}
