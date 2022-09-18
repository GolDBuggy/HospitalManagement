package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.MedicalAnalysisDto;
import com.java.hospitalmanagement.Dto.MemberInformationDto;
import com.java.hospitalmanagement.Model.MedicalAnalysis;
import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Repository.MedicalAnalysisRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalAnalysisService {

    private final MedicalAnalysisRepo analysisRepo;
    private final ModelMapper modelMapper;
    private final MemberService memberService;


    public List<MedicalAnalysis> getAll(){
        return  analysisRepo.findAll();
    }


    public MedicalAnalysisDto saveAnalysis(MedicalAnalysisDto medicalAnalysisDto){
       MedicalAnalysis medicalAnalysis=MedicalAnalysis.builder().id(UUID.randomUUID().toString()).
                                            member(mapMemberById(medicalAnalysisDto.getPersonalId())).
                                            analysisDate(LocalDate.now()).analysis(medicalAnalysisDto.getAnalysis()).build();
        analysisRepo.save(medicalAnalysis);
        return medicalAnalysisDto;
    }

    private MemberInformationDto mapMemberById(String personalId){
            MemberInformationDto informationDto=modelMapper.map(memberService.getByPersonelId(personalId),MemberInformationDto.class);
            return informationDto;
    }

}
