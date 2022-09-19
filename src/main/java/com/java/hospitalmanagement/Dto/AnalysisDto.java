package com.java.hospitalmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisDto {

    private String processName;
    private String result;
    private String resultUnit;
    private String referenceValue;
    private Date analysisDate;
}
