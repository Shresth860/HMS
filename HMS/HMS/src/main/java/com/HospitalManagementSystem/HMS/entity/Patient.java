package com.HospitalManagementSystem.HMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor  // generates a default constructor (important for JSON parsing)
@AllArgsConstructor
@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;
    private String mobileNumber;
    @Column(nullable = false, unique = true)
    private String patientGmail;

    private String gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private  String bloodGroup;

    @Column(nullable = false)
    private  String disease;
    private  String medicalHistory;

    private String status;
    private String insuranceProvider;
    private String policyNumber;


//    // ✅ Many patients -> One doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id") // foreign key column in patient table
    private Doctor doctor;


}
