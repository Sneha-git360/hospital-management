package com.example.hospital_management.controller;

import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {

        return service.savePatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {

        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Integer id) {
        return service.getPatientById(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Integer id,
                                 @RequestBody Patient patient) {

        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Integer id) {
        return service.deletePatient(id);
    }
}