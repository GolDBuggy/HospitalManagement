package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Model.Medicine;
import com.java.hospitalmanagement.Service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @PostMapping("/save")
    public void saveMedicine(@RequestBody Medicine medicine){
        medicineService.save(medicine);
    }

}
