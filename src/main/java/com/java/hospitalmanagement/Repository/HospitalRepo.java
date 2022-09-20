package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepo extends JpaRepository<Hospital,Long> {

    Optional<Hospital> findByHospitalName(String name);
}
