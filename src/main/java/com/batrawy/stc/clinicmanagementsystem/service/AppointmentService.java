package com.batrawy.stc.clinicmanagementsystem.service;

import com.batrawy.stc.clinicmanagementsystem.dto.AppointmentDto;
import com.batrawy.stc.clinicmanagementsystem.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentRequestDto);

    List<AppointmentDto> getTodayAppointments();

    Appointment getAppointmentById(Long appointmentId);

    List<AppointmentDto> getAppointmentsBetween(LocalDate startDate, LocalDate endDate);

    List<AppointmentDto> getAppointmentsForPatient(Long id);

    List<AppointmentDto> getAppointmentsForPatientByName(String patientName);
}
