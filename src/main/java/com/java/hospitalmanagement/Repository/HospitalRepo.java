package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital,Long> {
}
