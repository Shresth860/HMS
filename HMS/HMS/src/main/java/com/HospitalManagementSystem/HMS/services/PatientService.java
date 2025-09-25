package com.HospitalManagementSystem.HMS.services;

import com.HospitalManagementSystem.HMS.entity.Patient;
import com.HospitalManagementSystem.HMS.repository.patientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientService {
    @Autowired
    private patientsRepo patientsRepo;

    public List<Patient> getAll() {
       return patientsRepo.findAll();
    }

    public Patient addPatient(Patient p) {
        return patientsRepo.save(p);
    }

    public Optional<Patient> updatePatient(String patientid , Patient updatePatient) {
       return patientsRepo.findById(patientid).map(existing -> {
            existing.setPatientGmail(updatePatient.getPatientGmail());
            existing.setMobileNumber(updatePatient.getMobileNumber());
            existing.setName(updatePatient.getName());
            return patientsRepo.save(existing);
        });
    }

    public boolean deletePatient(String patientId) {
       if(patientsRepo.existsById(patientId)){
           patientsRepo.deleteById(patientId);
           return true;
       }
       return false;
    }

    public List<Patient> getByDisease(String disease) {
        return patientsRepo.findByDisease(disease);
    }



}
