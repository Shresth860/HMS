package com.HospitalManagementSystem.HMS.controller;

import com.HospitalManagementSystem.HMS.entity.Doctor;
//import com.HospitalManagementSystem.HMS.entity.doctor;
import com.HospitalManagementSystem.HMS.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/specialization/{specialization}")
    public List<Doctor> findBySpecialization(@PathVariable String specialization) {
        return doctorService.findBySpecialization(specialization);
    }

    @GetMapping("/name/{doctorName}")
    public List<Doctor> findByDoctorName(@PathVariable String doctorName) {
        return doctorService.findByDoctorName(doctorName);
    }

    @PostMapping("/new")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @PutMapping("/updateDoctor/{doctorId}")
    public Optional<Doctor> updateDoctor(@PathVariable Long doctorId, @RequestBody Doctor update) {
        return doctorService.UpdateDoctor(doctorId, update);
    }

    @DeleteMapping("/deleteById/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorId) {
        if (doctorService.deleteDoctor(doctorId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteByName/{doctorName}")
    public ResponseEntity<Void> deleteDoctorByName(@PathVariable String doctorName) {
        if (doctorService.deleteDoctorByName(doctorName)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
