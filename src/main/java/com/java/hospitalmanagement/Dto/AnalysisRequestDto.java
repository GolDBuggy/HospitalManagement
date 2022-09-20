package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisRequestDto {

    private String id;
    private DoctorNameDto doctor;
    private MemberInformationDto member;
    private String analysisName;
    private LocalDateTime sendTime;


}
