package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.AnalysisProperty;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAnalysisDto {

    private String name;

    private MemberInformationDto member;

    private DoctorNameDto doctor;

    private List<AnalysisDto> analysisProperties;
}
