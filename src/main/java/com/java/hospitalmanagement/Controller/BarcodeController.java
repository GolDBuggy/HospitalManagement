package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.BarcodeMemberDto;
import com.java.hospitalmanagement.Dto.BarcodeResponseDto;
import com.java.hospitalmanagement.Model.Barcode;
import com.java.hospitalmanagement.Service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/barcode")
@RequiredArgsConstructor
public class BarcodeController {

    private final BarcodeService barcodeService;

    @PostMapping("/create")
    public ResponseEntity<BarcodeMemberDto> create(@RequestBody BarcodeMemberDto barcodeMemberDto, Principal principal){
        barcodeService.createBarcode(barcodeMemberDto,principal);
        return ResponseEntity.accepted().body(barcodeMemberDto);
    }

    @GetMapping("/{barcodeId}")
    public ResponseEntity<BarcodeResponseDto> getByBarcode(@PathVariable String barcodeId){
        return ResponseEntity.accepted().body(barcodeService.getById(barcodeId));
    }
}
