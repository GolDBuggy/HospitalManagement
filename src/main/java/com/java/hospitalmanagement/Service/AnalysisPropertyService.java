package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.AnalysisProperty;
import com.java.hospitalmanagement.Repository.AnalysisPropertyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnalysisPropertyService {

    private final AnalysisPropertyRepo propertyRepo;

    public void saveAll(List<AnalysisProperty> analysisProperties){
        analysisProperties.stream().forEach(e -> e.setId(UUID.randomUUID().toString()));
        propertyRepo.saveAll(analysisProperties);
    }

    public void save(AnalysisProperty analysisProperty){
        propertyRepo.save(analysisProperty);
    }

    public List<AnalysisProperty> getAll(){
        return propertyRepo.findAll();
    }
}
