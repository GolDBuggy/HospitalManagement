package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.*;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Model.RequestTable;
import com.java.hospitalmanagement.Repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    private final KafkaTemplate<String,AnalysisRequestDto> template;
    private static String REQUEST="analysis_request";


    public void saveDoctor(Doctor doctor, Principal principal){
        doctor.setId(UUID.randomUUID().toString());
        doctor.setMember(memberService.getByPersonalId(principal.getName()));
        doctorRepo.save(doctor);
    }

    public Doctor getByPersonalId(String personalId){
        return doctorRepo.findByMember_PersonalId(personalId).get();
    }

    @Transactional
    public void sendAnalysisRequest(AnalysisRequestDto analysisRequestDto,Principal principal){
        analysisRequestDto.setId(UUID.randomUUID().toString());
        analysisRequestDto.setMember(mapMember(analysisRequestDto.getMember().getPersonalId()));
        analysisRequestDto.setDoctor(mapDoctor(getByPersonalId(principal.getName())));
        analysisRequestDto.setSendTime(LocalDateTime.now());
        template.send(REQUEST,analysisRequestDto);
    }

    private MemberInformationDto mapMember(String personalId){
        MemberInformationDto informationDto=modelMapper.map(memberService.getByPersonalId(personalId),MemberInformationDto.class);
        return informationDto;
    }

    private DoctorMemberDto mapDoctor(Doctor doctor){
        DoctorMemberDto doctorDto=DoctorMemberDto.builder().firstName(doctor.getMember().getFirstName()).
                lastName(doctor.getMember().getLastName()).build();
        return doctorDto;
    }



}
