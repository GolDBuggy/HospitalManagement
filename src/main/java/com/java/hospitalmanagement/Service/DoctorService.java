package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final MemberService memberService;


    public void saveDoctor(Doctor doctor, Principal principal){
        doctor.setId(UUID.randomUUID().toString());
        doctor.setMember(memberService.getByEmail(principal.getName()));
        doctorRepo.save(doctor);
    }


}
