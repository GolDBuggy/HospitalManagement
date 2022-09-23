package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepo extends JpaRepository<Vaccine,Long> {
}
