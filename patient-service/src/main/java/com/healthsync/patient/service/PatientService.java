package com.healthsync.patient.service;

import com.healthsync.patient.dto.PatientRequestDTO;
import com.healthsync.patient.dto.PatientResponseDTO;
import com.healthsync.patient.entity.Patient;
import com.healthsync.patient.exception.ResourceNotFoundException;
import com.healthsync.patient.mapper.PatientMapper;
import com.healthsync.patient.repository.PatientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    private final PatientRepository repository;

    public PatientResponseDTO createPatient(PatientRequestDTO dto) {

        log.info("Creating patient with email: {}", dto.getEmail());

        Patient patient = PatientMapper.mapToEntity(dto);

        Patient savedPatient = repository.save(patient);

        log.info("Patient created successfully with id: {}",
                savedPatient.getId());

        return PatientMapper.mapToDTO(savedPatient);
    }

    public List<Patient> getAllPatients() {

        log.info("Fetching all patients");

        return repository.findAll();
    }

    public Patient getPatientById(Long id) {

        log.info("Fetching patient with id: {}", id);

        return repository.findById(id)
                .orElseThrow(() -> {

                    log.error("Patient not found with id: {}", id);

                    return new ResourceNotFoundException(
                            "Patient not found with id: " + id);
                });
    }

    public void deletePatient(Long id) {

        log.warn("Deleting patient with id: {}", id);

        Patient patient = getPatientById(id);

        repository.delete(patient);

        log.info("Patient deleted successfully with id: {}", id);
    }
}