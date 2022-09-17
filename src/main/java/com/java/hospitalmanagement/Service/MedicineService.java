package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.Medicine;
import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Repository.MedicineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepo medicineRepo;
    private final DoctorService doctorService;
    private final MemberService memberService;
    public void save(Medicine medicine, Principal principal){
        medicine.setId(UUID.randomUUID().toString());
        medicine.setDoctor(doctorService.getByPersonalId(principal.getName()));
        medicineRepo.save(medicine);
    }


}
