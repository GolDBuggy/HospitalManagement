package com.java.hospitalmanagement.Dto;

import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Model.Medicine;
import com.java.hospitalmanagement.Model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarcodeMemberDto {

    private String disease;
    private List<Medicine> medicines;
    private String personalId;

}
