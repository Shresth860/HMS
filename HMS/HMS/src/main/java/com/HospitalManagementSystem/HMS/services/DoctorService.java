package com.HospitalManagementSystem.HMS.services;

import com.HospitalManagementSystem.HMS.entity.Doctor;
import com.HospitalManagementSystem.HMS.repository.DoctorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepository;


    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    public List<Doctor> findByDoctorName(String doctorName) {
        return doctorRepository.findByName(doctorName);
    }




    public boolean deleteDoctor(Long doctorId) {
        if (doctorRepository.existsById(doctorId)) {
            doctorRepository.deleteById(doctorId);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteDoctorByName(String name) {
        List<Doctor> doctorsToDelete = doctorRepository.findByName(name);
        if (!doctorsToDelete.isEmpty()) {
            doctorRepository.deleteAll(doctorsToDelete);
            return true;
        }
        return false;
    }

    @Transactional
    public Optional<Doctor> UpdateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id).map(existingDoctor -> {
            existingDoctor.setName(updatedDoctor.getName());
            existingDoctor.setDoctorGmail(updatedDoctor.getDoctorGmail());
            existingDoctor.setDoctorNumber(updatedDoctor.getDoctorNumber());
            existingDoctor.setQualification(updatedDoctor.getQualification());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setExperienceYears(updatedDoctor.getExperienceYears());
            return doctorRepository.save(existingDoctor);
        });
    }


}
