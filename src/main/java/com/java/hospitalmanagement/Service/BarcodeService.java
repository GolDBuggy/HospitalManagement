package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.BarcodeMemberDto;
import com.java.hospitalmanagement.Dto.BarcodeResponseDto;
import com.java.hospitalmanagement.Model.Barcode;
import com.java.hospitalmanagement.Repository.BarcodeRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BarcodeService {

    private final BarcodeRepo barcodeRepo;
    private final MemberService memberService;
    private final DoctorService doctorService;
    private final ModelMapper mapper;


    public void createBarcode(BarcodeMemberDto barcodeMemberDto, Principal principal){
       Barcode barcode=Barcode.builder().id(UUID.randomUUID().toString()).
               disease(barcodeMemberDto.getDisease()).
               member(memberService.getByPersonalId(barcodeMemberDto.getPersonalId())).
               doctor(doctorService.getByPersonalId(principal.getName())).medicines(barcodeMemberDto.getMedicines()).build();
        barcodeRepo.save(barcode);
    }


    public BarcodeResponseDto getById(String id){
        BarcodeResponseDto barcodeResponseDto=mapper.map(barcodeRepo.findById(id).get(),BarcodeResponseDto.class);
        return barcodeResponseDto;
    }


}
