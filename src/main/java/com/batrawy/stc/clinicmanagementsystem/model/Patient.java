package com.batrawy.stc.clinicmanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PATIENT")
public class Patient extends BaseEntity {
    private String patientName;
    private String phoneNumber;
    private LocalDate birthDate;
}
