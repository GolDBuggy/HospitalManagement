package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.MedicalAnalysisDto;
import com.java.hospitalmanagement.Model.MedicalAnalysis;
import com.java.hospitalmanagement.Repository.MedicalAnalysisRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalAnalysisService {

    private final MedicalAnalysisRepo analysisRepo;
    private final AnalysisPropertyService propertyService;
    private final DoctorService doctorService;
    private final ModelMapper modelMapper;
    private final MemberService memberService;


    public List<MedicalAnalysisDto> getAll(){
        return  mapMedicalAnalysis(analysisRepo.findAll());
    }


    @Transactional
    public MedicalAnalysis saveAnalysis(MedicalAnalysis medicalAnalysis, Principal principal){
        medicalAnalysis=setMedicalAnalysis(medicalAnalysis,principal);
        propertyService.saveAll(medicalAnalysis.getAnalysisProperties());
        analysisRepo.save(medicalAnalysis);
        return medicalAnalysis;
    }

    private MedicalAnalysis setMedicalAnalysis(MedicalAnalysis medicalAnalysis,Principal principal){
        medicalAnalysis.setId(UUID.randomUUID().toString());
        medicalAnalysis.setDoctor(doctorService.getByPersonalId(principal.getName()));
        medicalAnalysis.setMember(memberService.getByPersonelId(medicalAnalysis.getMember().getPersonalId()));
        medicalAnalysis.getAnalysisProperties().forEach(e -> e.setMedicalAnalysis(medicalAnalysis));
        return medicalAnalysis;
    }

    private List<MedicalAnalysisDto> mapMedicalAnalysis(List<MedicalAnalysis> medicalAnalysis){
        List<MedicalAnalysisDto> medicalAnalysisDto=medicalAnalysis.stream().map(e -> modelMapper.map(e,MedicalAnalysisDto.class)).collect(Collectors.toList());
        return medicalAnalysisDto;
    }



}
