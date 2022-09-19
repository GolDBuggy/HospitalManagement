package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.MedicalAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAnalysisRepo extends JpaRepository<MedicalAnalysis,String> {
}
