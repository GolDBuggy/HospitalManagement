package com.java.hospitalmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {

    private String name;
    private String prescriptions;
    private Date expireDate;
}
