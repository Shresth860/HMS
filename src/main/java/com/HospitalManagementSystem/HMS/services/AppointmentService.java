package com.HospitalManagementSystem.HMS.services;

import com.HospitalManagementSystem.HMS.entity.Appointment;
import com.HospitalManagementSystem.HMS.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    public Appointment addAppointment(Appointment a) {
        return appointmentRepo.save(a);
    }

    public Optional<Appointment> updateAppointment(Long appointmentId, Appointment update) {
        return appointmentRepo.findById(appointmentId).map(existing -> {
            existing.setStatus(update.getStatus());
            existing.setReason(update.getReason());
           existing.setAppointmentDate(update.getAppointmentDate());
           existing.setPatient(update.getPatient());
//           existing.setDoctor(update.getDoctor());
            // Save updated entity
            return appointmentRepo.save(existing);
        });
    }


    public boolean deleteAppointment(Long appointmentId) {
        if(appointmentRepo.existsById(appointmentId)){
            appointmentRepo.deleteById(appointmentId);
           return true;
        }
        return false;
    }
}
