package com.HospitalManagementSystem.HMS.repository;
import com.HospitalManagementSystem.HMS.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface patientsRepo extends JpaRepository<Patient, String> {
    List<Patient> findByDisease(String disease);
}
