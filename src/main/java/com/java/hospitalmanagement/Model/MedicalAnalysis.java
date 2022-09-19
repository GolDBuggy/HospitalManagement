package com.java.hospitalmanagement.Model;

import com.java.hospitalmanagement.Dto.MemberInformationDto;
import lombok.*;


import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "analysis")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalAnalysis {

    @Id
    @Column(name = "analysis_id")
    private String id;

    @Column(name = "analysis_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "medicalAnalysis")
    private List<AnalysisProperty> analysisProperties;







}
