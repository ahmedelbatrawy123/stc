package com.batrawy.stc.clinicmanagementsystem.repository;

import com.batrawy.stc.clinicmanagementsystem.model.Appointment;
import com.batrawy.stc.clinicmanagementsystem.model.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end);

    List<Appointment> findByPatient(Patient patient);
}
