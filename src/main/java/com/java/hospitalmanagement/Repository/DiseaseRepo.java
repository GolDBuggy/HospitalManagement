package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepo extends JpaRepository<Disease,String> {
}
