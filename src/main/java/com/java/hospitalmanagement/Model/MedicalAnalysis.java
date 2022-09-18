package com.java.hospitalmanagement.Model;

import com.java.hospitalmanagement.Dto.MemberInformationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalAnalysis {

    @Id
    private String id;

    private MemberInformationDto member;

    private LocalDate analysisDate;

    private List<HashMap<String,AnalysisColumn>> analysis;








}
