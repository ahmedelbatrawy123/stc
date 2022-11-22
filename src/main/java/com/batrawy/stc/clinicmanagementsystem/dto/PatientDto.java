package com.batrawy.stc.clinicmanagementsystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto extends BaseDTO {
    private String patientName;
    private String phoneNumber;
    private LocalDate birthDate;
}
