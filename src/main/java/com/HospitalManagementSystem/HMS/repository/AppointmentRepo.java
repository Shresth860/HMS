package com.HospitalManagementSystem.HMS.repository;

import com.HospitalManagementSystem.HMS.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment , Long> {
}
