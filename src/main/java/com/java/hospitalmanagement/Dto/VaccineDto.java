package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Hospital;
import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDto {

    private String name;
    private String company;
    private int dose;
    private LocalDate date;
    private HospitalDto hospital;
    private MemberInformationDto member;
    private DoctorNameDto doctor;
}
