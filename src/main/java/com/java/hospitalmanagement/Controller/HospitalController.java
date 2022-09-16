package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Model.Hospital;
import com.java.hospitalmanagement.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping("/save")
    public ResponseEntity<Hospital> save(@RequestBody Hospital hospital){
        hospitalService.saveHospital(hospital);
        return ResponseEntity.accepted().body(hospital);
    }
}
