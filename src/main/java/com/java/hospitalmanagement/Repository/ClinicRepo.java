package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Clinic;
import com.java.hospitalmanagement.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicRepo extends JpaRepository<Clinic,String> {

    Optional<Clinic> findByClinicNameAndHospitals(String clinicName, Hospital hospital);
}
