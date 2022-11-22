package com.batrawy.stc.clinicmanagementsystem.service;

import com.batrawy.stc.clinicmanagementsystem.dto.PatientDto;
import com.batrawy.stc.clinicmanagementsystem.model.Patient;

public interface PatientService {
    PatientDto createPatient(PatientDto dto);

    Patient getPatientById(Long patientId);
}
