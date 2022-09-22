package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.*;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Model.RequestTable;
import com.java.hospitalmanagement.Repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final RequestTableService tableService;
    private final MemberService memberService;
    private final ModelMapper modelMapper;


    public Doctor findByDoctorName(String firstname,String lastname){
        return doctorRepo.findByMember_FirstNameAndMember_LastName(firstname,lastname).get();
    }



    public void saveDoctor(Doctor doctor, Principal principal){
        doctor.setId(UUID.randomUUID().toString());
        doctor.setMember(memberService.getByPersonalId(principal.getName()));
        doctorRepo.save(doctor);
    }

    public Doctor getByPersonalId(String personalId){
        return doctorRepo.findByMember_PersonalId(personalId).get();
    }


    public void sendAnalysisRequest(RequestTable table,Principal principal){
        table.setId(UUID.randomUUID().toString());
        table.setMember(memberService.getByPersonalId(table.getMember().getPersonalId()));
        table.setDoctor(getByPersonalId(principal.getName()));
        table.setSendTime(LocalDateTime.now());
        tableService.save(table);

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
