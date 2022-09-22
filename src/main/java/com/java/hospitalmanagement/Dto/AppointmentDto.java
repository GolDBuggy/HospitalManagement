package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Clinic;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Hospital;
import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDto {

    private HospitalDto hospital;
    private ClinicDto clinic;
    private DoctorNameDto doctor;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
