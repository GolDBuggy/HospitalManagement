package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.VaccineDto;
import com.java.hospitalmanagement.Model.Vaccine;
import com.java.hospitalmanagement.Service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/vaccine")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    @PostMapping("/save")
    public ResponseEntity<VaccineDto> save(@RequestBody VaccineDto vaccineDto, Principal principal){
        vaccineService.save(vaccineDto,principal);
        return ResponseEntity.status(HttpStatus.OK).body(vaccineDto);
    }

    @GetMapping("/my")
    public ResponseEntity<List<VaccineDto>> getMemberVaccine(Principal principal){
        return ResponseEntity.accepted().body(vaccineService.getMemberVaccine(principal));
    }
}
