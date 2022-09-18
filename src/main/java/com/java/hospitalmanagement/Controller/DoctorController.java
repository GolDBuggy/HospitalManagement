package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.AnalysisRequestDto;
import com.java.hospitalmanagement.Model.Clinic;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Service.ClinicService;
import com.java.hospitalmanagement.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<Doctor> save(@RequestBody Doctor doctor, Principal principal){
        doctorService.saveDoctor(doctor,principal);
        return ResponseEntity.accepted().body(doctor);
    }

    @PostMapping("/send")
    public ResponseEntity<String> analysisRequest(@RequestBody AnalysisRequestDto analysisRequestDto, Principal principal){
        doctorService.sendAnalysisRequest(analysisRequestDto,principal);
        return ResponseEntity.accepted().body("Request sended successfully!");
    }


}
