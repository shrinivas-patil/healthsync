package com.healthsync.patient.service;

import com.healthsync.patient.dto.PatientRequestDTO;
import com.healthsync.patient.dto.PatientResponseDTO;
import com.healthsync.patient.entity.Patient;
import com.healthsync.patient.mapper.PatientMapper;
import com.healthsync.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.healthsync.patient.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public PatientResponseDTO createPatient(PatientRequestDTO dto) {

        Patient patient = PatientMapper.mapToEntity(dto);

        Patient savedPatient = repository.save(patient);

        return PatientMapper.mapToDTO(savedPatient);
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient getPatientById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found with id: " + id));
    }

    public void deletePatient(Long id) {

        Patient patient = getPatientById(id);

        repository.delete(patient);
    }
}