package com.HospitalManagementSystem.HMS.repository;

import com.HospitalManagementSystem.HMS.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialization(String specialization);
    void deleteByName(String doctorName);
    List<Doctor> findByName(String name);
}
