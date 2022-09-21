package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    private String reportType;
    private LocalDate date;
    private MemberInformationDto member;
    private DoctorNameDto doctor;
}
