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
    public void save(Medicine medicine){
        medicine.setId(UUID.randomUUID().toString());
        medicineRepo.save(medicine);
    }


}
