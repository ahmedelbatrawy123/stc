package com.batrawy.stc.clinicmanagementsystem.mapper;

import com.batrawy.stc.clinicmanagementsystem.dto.PatientDto;
import com.batrawy.stc.clinicmanagementsystem.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper extends BaseMapper<PatientDto, Patient> {

}
