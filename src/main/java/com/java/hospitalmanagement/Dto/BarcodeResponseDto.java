package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarcodeResponseDto {

    private String disease;
    private MemberInformationDto member;
    private List<MedicineDto> medicines;
}
