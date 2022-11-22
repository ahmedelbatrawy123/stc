package com.batrawy.stc.clinicmanagementsystem.repository;

import com.batrawy.stc.clinicmanagementsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByPatientName(String patientName);
}
