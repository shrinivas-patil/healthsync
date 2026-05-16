package com.healthsync.patient.controller;

import com.healthsync.patient.dto.PatientRequestDTO;
import com.healthsync.patient.dto.PatientResponseDTO;
import com.healthsync.patient.entity.Patient;
import com.healthsync.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @PostMapping
    public PatientResponseDTO createPatient(
            @RequestBody PatientRequestDTO dto) {

        return service.createPatient(dto);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(
            @PathVariable Long id) {

        return service.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(
            @PathVariable Long id) {

        service.deletePatient(id);

        return "Patient deleted successfully";
    }
}