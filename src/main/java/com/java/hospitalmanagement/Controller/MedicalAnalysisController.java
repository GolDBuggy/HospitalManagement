package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.MedicalAnalysisDto;
import com.java.hospitalmanagement.Model.MedicalAnalysis;
import com.java.hospitalmanagement.Service.MedicalAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class MedicalAnalysisController {

    private final MedicalAnalysisService analysisService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MedicalAnalysis medicalAnalysis, Principal principal){
        analysisService.saveAnalysis(medicalAnalysis,principal);
       return ResponseEntity.accepted().body("Saved Successfully!");
    }


    @GetMapping("/all")
    public ResponseEntity<List<MedicalAnalysisDto>> getAll(){
        return ResponseEntity.accepted().body(analysisService.getAll());
    }
}
