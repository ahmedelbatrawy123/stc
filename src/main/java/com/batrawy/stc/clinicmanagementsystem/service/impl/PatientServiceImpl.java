package com.batrawy.stc.clinicmanagementsystem.service.impl;

import com.batrawy.stc.clinicmanagementsystem.dto.PatientDto;
import com.batrawy.stc.clinicmanagementsystem.exception.ResourceNotFoundException;
import com.batrawy.stc.clinicmanagementsystem.mapper.PatientMapper;
import com.batrawy.stc.clinicmanagementsystem.model.Patient;
import com.batrawy.stc.clinicmanagementsystem.repository.PatientRepository;
import com.batrawy.stc.clinicmanagementsystem.service.PatientService;
import com.batrawy.stc.clinicmanagementsystem.utils.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientDto createPatient(PatientDto dto) {
        Patient patient = patientRepository.save(patientMapper.toEntity(dto));
        return patientMapper.toDTO(patient);
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RESOURCE_NOT_FOUND_EXCEPTION));
    }
}
