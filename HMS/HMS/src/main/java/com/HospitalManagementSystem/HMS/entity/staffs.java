package com.HospitalManagementSystem.HMS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long staffId;

    private  String name;
    private  String role;  // nurse, lab technician , receptionist , medicalStore manager , cleaning staff
    private String contactNumber;
    private String email;
}
