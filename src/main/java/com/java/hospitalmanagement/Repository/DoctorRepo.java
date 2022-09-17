package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DoctorRepo extends JpaRepository<Doctor,String> {

    Optional<Doctor> findByMember_PersonalId(String personalId);
}
