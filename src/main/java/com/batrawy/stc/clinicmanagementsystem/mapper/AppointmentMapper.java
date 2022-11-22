package com.batrawy.stc.clinicmanagementsystem.mapper;

import com.batrawy.stc.clinicmanagementsystem.dto.AppointmentDto;
import com.batrawy.stc.clinicmanagementsystem.model.Appointment;
import com.batrawy.stc.clinicmanagementsystem.model.Patient;
import com.batrawy.stc.clinicmanagementsystem.service.PatientService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {
    @Autowired
    private PatientService patientService;

    @Mapping(source = "patientId", target = "patient")
    public abstract Appointment toEntity(AppointmentDto dto);

    @Mapping(target = "patientId", source = "patient.id")
    public abstract AppointmentDto toDTO(Appointment entity);

    public abstract List<AppointmentDto> toDTOList(List<Appointment> entityList);

    public Patient getPatientById(Long patientId) {
        return patientService.getPatientById(patientId);
    }
}
