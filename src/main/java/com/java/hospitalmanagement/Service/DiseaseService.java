package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.DiseaseDto;
import com.java.hospitalmanagement.Dto.DiseaseMemberDto;
import com.java.hospitalmanagement.Model.Disease;
import com.java.hospitalmanagement.Repository.DiseaseRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiseaseService {

    private final DiseaseRepo diseaseRepo;
    private final DoctorService doctorService;
    private final MemberService memberService;
    private final HospitalService hospitalService;
    private final ModelMapper modelMapper;


    public List<DiseaseMemberDto> getAll(Principal principal){
        List<DiseaseMemberDto> diseaseDtos=memberService.getByPersonalId(principal.getName()).
                getDiseases().stream().map(e -> modelMapper.map(e, DiseaseMemberDto.class)).collect(Collectors.toList());
        return diseaseDtos;
    }

    public void save(DiseaseDto diseaseDto, Principal principal){
        diseaseRepo.save(mapDisease(diseaseDto,principal));
    }

    private Disease mapDisease(DiseaseDto diseaseDto,Principal principal){
        Disease disease=Disease.builder().id(UUID.randomUUID().toString()).
                doctor(doctorService.getByPersonalId(principal.getName())).
                name(diseaseDto.getName()).member(memberService.getByPersonalId(diseaseDto.getMember().getPersonalId())).
                hospital(hospitalService.getByName(diseaseDto.getHospital().getHospitalName())).build();

        return disease;
    }
}
