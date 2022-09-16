package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepo extends JpaRepository<Clinic,String> {
}
