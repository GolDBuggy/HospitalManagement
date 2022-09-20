package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Hospital;
import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseDto {

    private String name;
    private MemberInformationDto member;
    private Doctor doctor;
    private HospitalDto hospital;

}
