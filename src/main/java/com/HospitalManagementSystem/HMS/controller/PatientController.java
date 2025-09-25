package com.HospitalManagementSystem.HMS.controller;

import com.HospitalManagementSystem.HMS.entity.Patient;
import com.HospitalManagementSystem.HMS.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Fetch all patients
    @GetMapping("/all")
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    // Fetch patient by disease
    @GetMapping("/disease/{disease}")
    public List<Patient> getByDisease(@PathVariable String disease) {
        return patientService.getByDisease(disease);
    }

    // Add new patient
    @PostMapping("/newPatient")
    public Patient addPatient(@RequestBody Patient p) {
        return patientService.addPatient(p);
    }

    // Update existing patient
    @PutMapping("/id/{patientId}")
    public Optional<Patient> updatePatient(@PathVariable("patientId") String patientId,
                                           @RequestBody Patient updatePatient) {
        return patientService.updatePatient(patientId, updatePatient);
    }

    // Delete patient
    @DeleteMapping("/delete/{id}")
    public boolean deletePatient(@PathVariable("id") String patientId) {
        return patientService.deletePatient(patientId);
    }
}
