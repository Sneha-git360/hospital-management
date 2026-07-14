package com.example.hospital_management.service;

import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient getPatientById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Patient updatePatient(Integer id, Patient patient) {

        Patient existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(patient.getName());
            existing.setAge(patient.getAge());
            existing.setGender(patient.getGender());
            existing.setDisease(patient.getDisease());
            existing.setStatus(patient.getStatus());

            return repository.save(existing);
        }

        return null;
    }

    public String deletePatient(Integer id) {

        repository.deleteById(id);

        return "Patient Deleted Successfully";
    }
}