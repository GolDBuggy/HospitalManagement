package com.java.hospitalmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisRequestDto {

    private String id;
    private DoctorDto doctor;
    private String personalId;
    private String analysisName;
    private LocalDateTime sendTime;
}
