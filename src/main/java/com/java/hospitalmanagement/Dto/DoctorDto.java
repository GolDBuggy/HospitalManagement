package com.java.hospitalmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {

    private String id;
    private String firstname;
    private String lastname;
}
