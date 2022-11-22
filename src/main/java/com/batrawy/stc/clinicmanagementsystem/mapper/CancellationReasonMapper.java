package com.batrawy.stc.clinicmanagementsystem.mapper;

import com.batrawy.stc.clinicmanagementsystem.dto.CancelAppointmentDto;
import com.batrawy.stc.clinicmanagementsystem.model.Appointment;
import com.batrawy.stc.clinicmanagementsystem.model.CancellationReason;
import com.batrawy.stc.clinicmanagementsystem.service.AppointmentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CancellationReasonMapper {

    @Autowired
    private AppointmentService appointmentService;

    @Mapping(source = "appointmentId", target = "appointment")
    public abstract CancellationReason fromDtoToEntity(CancelAppointmentDto dto);

    @Mapping(target = "appointmentId", source = "appointment.id")
    public abstract CancelAppointmentDto toDto(CancellationReason entity);

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }
}
