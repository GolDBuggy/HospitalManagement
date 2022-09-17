package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.BarcodeMemberDto;
import com.java.hospitalmanagement.Model.Barcode;
import com.java.hospitalmanagement.Service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
