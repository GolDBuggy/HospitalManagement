package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.AnalysisColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAnalysisDto {

    private String personalId;
    private LocalDate analysisDate;
    private List<HashMap<String, AnalysisColumn>> analysis;
}
