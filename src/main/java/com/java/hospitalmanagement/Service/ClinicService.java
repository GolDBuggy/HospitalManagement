package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.Clinic;
import com.java.hospitalmanagement.Model.Hospital;
import com.java.hospitalmanagement.Repository.ClinicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepo clinicRepo;

    public void saveClinic(Clinic clinic){
        clinic.setId(UUID.randomUUID().toString());
        clinicRepo.save(clinic);
    }

    public Clinic getByClinicNameAndHospital(String clinicName, Hospital hospital){
        return clinicRepo.findByClinicNameAndHospitals(clinicName,hospital).get();
    }
}
