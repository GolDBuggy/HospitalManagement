package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseMemberDto {

    private String name;
    private MemberInformationDto member;
    private DoctorNameDto doctor;
    private HospitalDto hospital;

}
