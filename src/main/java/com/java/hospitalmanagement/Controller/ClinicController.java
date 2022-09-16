package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Model.Clinic;
import com.java.hospitalmanagement.Model.Hospital;
import com.java.hospitalmanagement.Service.ClinicService;
import com.java.hospitalmanagement.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @PostMapping("/save")
    public ResponseEntity<Clinic> save(@RequestBody Clinic clinic){
        clinicService.saveClinic(clinic);
        return ResponseEntity.accepted().body(clinic);
    }
}
