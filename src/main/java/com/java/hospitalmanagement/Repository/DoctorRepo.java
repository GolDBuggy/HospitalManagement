package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepo extends JpaRepository<Doctor,String> {
}
