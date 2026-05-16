package com.healthsync.patient.mapper;

import com.healthsync.patient.dto.PatientRequestDTO;
import com.healthsync.patient.dto.PatientResponseDTO;
import com.healthsync.patient.entity.Patient;

public class PatientMapper {

    public static Patient mapToEntity(PatientRequestDTO dto) {

        Patient patient = new Patient();

        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setPhone(dto.getPhone());
        patient.setAge(dto.getAge());

        return patient;
    }

    public static PatientResponseDTO mapToDTO(Patient patient) {

        return PatientResponseDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .age(patient.getAge())
                .build();
    }
}