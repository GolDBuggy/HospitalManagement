package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisRequestDto {

    private String id;
    private DoctorMemberDto doctor;
    private Member member;
    private String analysisName;
    private LocalDateTime sendTime;
}
