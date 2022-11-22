package com.batrawy.stc.clinicmanagementsystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto extends BaseDTO {
    private Long patientId;
    private LocalDateTime appointmentDate;
}
