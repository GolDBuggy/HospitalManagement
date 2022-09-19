package com.java.hospitalmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "analysis_property")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisProperty {

    @Id
    @Column(name = "property_id")
    private String id;

    @Column(name = "process_name")
    private String processName;

    @Column(name = "analysis_result")
    private String result;

    @Column(name = "result_unit")
    private String resultUnit;

    @Column(name = "reference_value")
    private String referenceValue;

    @Column(name = "analysis_date")
    private Date analysisDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "analysis_id")
    @JsonIgnore
    private MedicalAnalysis medicalAnalysis;

}
