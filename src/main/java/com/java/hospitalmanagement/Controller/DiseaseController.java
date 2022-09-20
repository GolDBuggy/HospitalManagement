package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.DiseaseDto;
import com.java.hospitalmanagement.Dto.DiseaseMemberDto;
import com.java.hospitalmanagement.Service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/disease")
@RequiredArgsConstructor
public class DiseaseController {

    private final DiseaseService diseaseService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody DiseaseDto diseaseDto, Principal principal){
        diseaseService.save(diseaseDto,principal);
        return ResponseEntity.accepted().body("Disease saved successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<DiseaseMemberDto>> getAll(Principal principal){
        return ResponseEntity.accepted().body(diseaseService.getAll(principal));
    }
}
