package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Model.Clinic;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Service.ClinicService;
import com.java.hospitalmanagement.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
