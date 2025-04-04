package com.i2i.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private String firstName;
    private String lastName;
    private String mrNumber;
    private LocalDate dateOfBirth;
}
