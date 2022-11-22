package com.batrawy.stc.clinicmanagementsystem.service.impl;

import com.batrawy.stc.clinicmanagementsystem.dto.AppointmentDto;
import com.batrawy.stc.clinicmanagementsystem.exception.ResourceNotFoundException;
import com.batrawy.stc.clinicmanagementsystem.mapper.AppointmentMapper;
import com.batrawy.stc.clinicmanagementsystem.model.Appointment;
import com.batrawy.stc.clinicmanagementsystem.model.Patient;
import com.batrawy.stc.clinicmanagementsystem.repository.AppointmentRepository;
import com.batrawy.stc.clinicmanagementsystem.repository.PatientRepository;
import com.batrawy.stc.clinicmanagementsystem.service.AppointmentService;
import com.batrawy.stc.clinicmanagementsystem.utils.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentRequestDto) {
        Appointment appointment = appointmentMapper.toEntity(appointmentRequestDto);
        return appointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    @Override
    public List<AppointmentDto> getTodayAppointments() {
        return appointmentMapper.toDTOList(appointmentRepository
                .findByAppointmentDateBetween(LocalDateTime.of(LocalDate.now(), LocalTime.MIN),
                        LocalDateTime.of(LocalDate.now(), LocalTime.MAX)));
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RESOURCE_NOT_FOUND_EXCEPTION));
    }

    @Override
    public List<AppointmentDto> getAppointmentsBetween(LocalDate startDate, LocalDate endDate) {
        return appointmentMapper.toDTOList(appointmentRepository
                .findByAppointmentDateBetween(LocalDateTime.of(startDate, LocalTime.MIN),
                        LocalDateTime.of(endDate, LocalTime.MAX)));
    }

    @Override
    public List<AppointmentDto> getAppointmentsForPatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constant.RESOURCE_NOT_FOUND_EXCEPTION));
        return appointmentMapper.toDTOList(appointmentRepository.findByPatient(patient));
    }

    @Override
    public List<AppointmentDto> getAppointmentsForPatientByName(String patientName) {
        Patient patient = patientRepository.findByPatientName(patientName);
        if (patient == null) {
            throw new ResourceNotFoundException(Constant.RESOURCE_NOT_FOUND_EXCEPTION);
        }
        return appointmentMapper.toDTOList(appointmentRepository.findByPatient(patient));
    }

}
