package com.HospitalManagementSystem.HMS.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
//
//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime appointmentDate;

    private String reason;
    private String Status; // Scheduled, Completed, Cancelled

}
