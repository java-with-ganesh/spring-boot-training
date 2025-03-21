package com.i2i.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class VitalSignDTO {

    private String pulse;

    private String temperature;

    private String respirations;

    private String bloodSugar;

    private String weight;

    private String height;

    private String spo2;

    private String ptInr;

    private String patientName;

    @NonNull
    private String patientMrnNumber;

    @NonNull
    private String documentedBy;
}
