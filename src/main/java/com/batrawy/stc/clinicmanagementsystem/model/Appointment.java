package com.batrawy.stc.clinicmanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "APPOINTMENT")
public class Appointment extends BaseEntity {

    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    private Patient patient;

}
