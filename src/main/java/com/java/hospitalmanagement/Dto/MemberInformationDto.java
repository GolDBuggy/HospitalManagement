package com.java.hospitalmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberInformationDto {

    private String firstName;
    private String lastName;
    private String personalId;
}
