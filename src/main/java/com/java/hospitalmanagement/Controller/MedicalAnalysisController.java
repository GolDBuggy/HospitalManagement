package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.MedicalAnalysisDto;
import com.java.hospitalmanagement.Model.MedicalAnalysis;
import com.java.hospitalmanagement.Service.MedicalAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class MedicalAnalysisController {

    private final MedicalAnalysisService analysisService;

    @PostMapping("/create")
    public ResponseEntity<MedicalAnalysisDto> create(@RequestBody MedicalAnalysisDto medicalAnalysisDto){
       return ResponseEntity.accepted().body(analysisService.saveAnalysis(medicalAnalysisDto));
    }

    //barcode oluşturulabilir

    @GetMapping("/all")
    public ResponseEntity<List<MedicalAnalysis>> getAll(){
        return ResponseEntity.accepted().body(analysisService.getAll());
    }
}
