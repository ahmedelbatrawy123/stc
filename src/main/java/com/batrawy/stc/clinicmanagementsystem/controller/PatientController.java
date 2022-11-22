package com.batrawy.stc.clinicmanagementsystem.controller;

import com.batrawy.stc.clinicmanagementsystem.dto.PatientDto;
import com.batrawy.stc.clinicmanagementsystem.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "patient")
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/patient")
public class PatientController {
    private final PatientService patientService;

    @ApiOperation(value = "add patient.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created") })
    @PostMapping("")
    public ResponseEntity<Void> createPatient(@RequestBody PatientDto dto) {
        patientService.createPatient(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
