package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.AnalysisRequestDto;
import com.java.hospitalmanagement.Dto.DoctorDto;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    private final KafkaTemplate<String,Object> template;
    private static String REQUEST="analysis_request";


    public void saveDoctor(Doctor doctor, Principal principal){
        doctor.setId(UUID.randomUUID().toString());
        doctor.setMember(memberService.getByPersonelId(principal.getName()));
        doctorRepo.save(doctor);
    }

    public Doctor getByPersonalId(String personalId){
        return doctorRepo.findByMember_PersonalId(personalId).get();
    }

    public void sendAnalysisRequest(AnalysisRequestDto analysisRequestDto,Principal principal){
        analysisRequestDto.setId(UUID.randomUUID().toString());
        analysisRequestDto.setDoctor(mapDoctor(getByPersonalId(principal.getName())));
        analysisRequestDto.setSendTime(LocalDateTime.now());
        template.send("analysis_request",analysisRequestDto);
    }

    private DoctorDto mapDoctor(Doctor doctor){
        DoctorDto doctorDto= DoctorDto.builder().id(doctor.getId()).firstname(doctor.getMember().getFirstName())
                .lastname(doctor.getMember().getLastName()).build();
        return doctorDto;
    }


}
