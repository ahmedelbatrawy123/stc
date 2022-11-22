package com.batrawy.stc.clinicmanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CANCELLATION_REASON")
public class CancellationReason extends BaseEntity {
    private String reason;

    @OneToOne
    @JoinColumn(name = "APPOINTMENT_ID", referencedColumnName = "ID")
    private Appointment appointment;
}
