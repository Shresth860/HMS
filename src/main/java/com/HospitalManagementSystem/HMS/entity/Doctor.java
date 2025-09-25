package com.HospitalManagementSystem.HMS.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import java.util.List;

@Data
@Entity
@Table(name = "doctors") // optional, but good practice
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @NonNull
    private String name;

    private String doctorGmail;

    @NonNull
    private String specialization;

    private String doctorNumber;

    private String qualification;

    private int experienceYears;

//    @OneToMany(mappedBy = "doctor")
//    private List<Appointment> appointments;

    // ✅ One doctor -> Many patients
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patient;

    public Doctor() {
        // default constructor required by JPA
    }
    @JsonCreator
    public Doctor(@JsonProperty("doctorId") Long doctorId) {
        this.doctorId = doctorId;
    }

    @Version
    private Integer version;
}
