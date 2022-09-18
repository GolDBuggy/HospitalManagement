package com.java.hospitalmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisColumn {

    private Object result;

    private String resultUnit;

    private String referenceValue;

}
