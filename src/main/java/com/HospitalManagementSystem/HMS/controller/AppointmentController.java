package com.HospitalManagementSystem.HMS.controller;

import com.HospitalManagementSystem.HMS.entity.Appointment;
import com.HospitalManagementSystem.HMS.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

   @Autowired
   private AppointmentService appointmentService;

    @GetMapping("/all")
    public List<Appointment> findAll(){
        return appointmentService.findAll();
    }

    @PostMapping("/addAppointment")
    public Appointment addAppointment(@RequestBody Appointment a){
        return appointmentService.addAppointment(a);
    }
    @PutMapping("/updateAppointment/{id}")
    public Optional<Appointment> updateAppointment(@PathVariable("id") Long appointmentId , Appointment update ){
        return  appointmentService.updateAppointment(appointmentId,update);
    }
    @DeleteMapping("/deleteAppointment/{id}")
    public boolean deleteAppointment(@PathVariable("id") Long appointmentId){
        return appointmentService.deleteAppointment(appointmentId);
    }
}
