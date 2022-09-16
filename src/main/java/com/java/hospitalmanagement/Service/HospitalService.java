package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.Clinic;
import com.java.hospitalmanagement.Model.Hospital;
import com.java.hospitalmanagement.Repository.ClinicRepo;
import com.java.hospitalmanagement.Repository.HospitalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {


    private final HospitalRepo hospitalRepo;

    public void saveHospital(Hospital hospital){
        hospitalRepo.save(hospital);
    }


}
