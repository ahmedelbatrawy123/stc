package com.batrawy.stc.clinicmanagementsystem.service.impl;

import com.batrawy.stc.clinicmanagementsystem.dto.CancelAppointmentDto;
import com.batrawy.stc.clinicmanagementsystem.mapper.CancellationReasonMapper;
import com.batrawy.stc.clinicmanagementsystem.repository.CancellationReasonRepository;
import com.batrawy.stc.clinicmanagementsystem.service.CancellationReasonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CancellationReasonServiceImpl implements CancellationReasonService {
    private final CancellationReasonMapper cancellationReasonMapper;
    private final CancellationReasonRepository cancellationReasonRepository;

    @Override
    public void cancelAppointment(CancelAppointmentDto dto) {
        cancellationReasonRepository.save(cancellationReasonMapper.fromDtoToEntity(dto));
    }
}
