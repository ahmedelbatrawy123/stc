package com.batrawy.stc.clinicmanagementsystem.service;

import com.batrawy.stc.clinicmanagementsystem.dto.CancelAppointmentDto;

public interface CancellationReasonService {
    void cancelAppointment(CancelAppointmentDto dto);
}
