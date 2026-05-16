package com.healthsync.patient.dto;

import lombok.Data;

@Data
public class PatientRequestDTO {

    private String name;
    private String email;
    private String phone;
    private Integer age;
}