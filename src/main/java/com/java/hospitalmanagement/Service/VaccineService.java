package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.VaccineDto;
import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Model.Vaccine;
import com.java.hospitalmanagement.Repository.VaccineRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepo vaccineRepo;
    private final HospitalService hospitalService;
    private final MemberService memberService;
    private final DoctorService doctorService;
    private final ModelMapper modelMapper;


    public void save(VaccineDto vaccineDto, Principal principal){
        checkVaccine(memberService.getByPersonalId(vaccineDto.getMember().getPersonalId()),vaccineDto.getName(),vaccineDto.getDose());
        Vaccine vaccine=Vaccine.builder().member(memberService.getByPersonalId(vaccineDto.getMember().getPersonalId())).
                                doctor(doctorService.getByPersonalId(principal.getName())).name(vaccineDto.getName()).
                company(vaccineDto.getCompany()).date(LocalDate.now()).dose(vaccineDto.getDose()).
                hospital(hospitalService.getByName(vaccineDto.getHospital().getHospitalName())).build();
        vaccineRepo.save(vaccine);
    }

    public List<VaccineDto> getMemberVaccine(Principal principal){
        return memberService.getByPersonalId(principal.getName()).getVaccines().stream().map(e -> modelMapper.map(e,VaccineDto.class)).collect(Collectors.toList());
    }

    private void checkVaccine(Member member,String name,int dose){
        if(vaccineRepo.existsByMemberAndNameAndDose(member,name,dose))
            throw new RuntimeException("Already saved!");
    }
}
