package com.batrawy.stc.clinicmanagementsystem.dto;

import lombok.Data;

@Data
public class CancelAppointmentDto {
    private Long appointmentId;
    private String reason;
}
