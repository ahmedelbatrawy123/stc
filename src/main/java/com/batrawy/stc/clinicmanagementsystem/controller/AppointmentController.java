package com.batrawy.stc.clinicmanagementsystem.controller;

import com.batrawy.stc.clinicmanagementsystem.dto.AppointmentDto;
import com.batrawy.stc.clinicmanagementsystem.dto.CancelAppointmentDto;
import com.batrawy.stc.clinicmanagementsystem.service.AppointmentService;
import com.batrawy.stc.clinicmanagementsystem.service.CancellationReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Api(tags = "appointment")
@AllArgsConstructor
@RestController
@RequestMapping("v1/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final CancellationReasonService cancellationReasonService;

    @ApiOperation(value = "add appointment.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created") })
    @PostMapping("")
    public ResponseEntity<Void> createAppointment(@RequestBody AppointmentDto appointmentRequestDto) {
        appointmentService.createAppointment(appointmentRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "cancel appointment.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Created") })
    @PostMapping("/cancel")
    public ResponseEntity<String> cancelAppointment(@RequestBody CancelAppointmentDto dto) {
        cancellationReasonService.cancelAppointment(dto);
        return new ResponseEntity<>("appointment canceled ", HttpStatus.OK);
    }

    @ApiOperation(value = "Get today appointments .")
    @ApiResponses(value = {
            @ApiResponse(response = List.class, code = 200, message = "OK") })
    @GetMapping("")
    public ResponseEntity<List<AppointmentDto>> getTodayAppointments() {
        return new ResponseEntity<>(appointmentService.getTodayAppointments(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get  appointments between  .")
    @ApiResponses(value = {
            @ApiResponse(response = List.class, code = 200, message = "OK") })
    @GetMapping("/search")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsBetween(@RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return new ResponseEntity<>(appointmentService.getAppointmentsBetween(startDate, endDate), HttpStatus.OK);
    }

    @ApiOperation(value = "Get  appointments for patient  .")
    @ApiResponses(value = {
            @ApiResponse(response = List.class, code = 200, message = "OK") })
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsForPatient(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentService.getAppointmentsForPatient(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get  appointments by patient name  .")
    @ApiResponses(value = {
            @ApiResponse(response = List.class, code = 200, message = "OK") })
    @GetMapping("/patient")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsForPatientByName(@RequestParam String patientName) {
        return new ResponseEntity<>(appointmentService.getAppointmentsForPatientByName(patientName), HttpStatus.OK);
    }
}
