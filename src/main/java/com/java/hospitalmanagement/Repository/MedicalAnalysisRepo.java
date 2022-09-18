package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.MedicalAnalysis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalAnalysisRepo extends MongoRepository<MedicalAnalysis,String> {
}
