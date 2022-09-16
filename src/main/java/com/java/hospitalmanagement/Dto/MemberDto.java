package com.java.hospitalmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private String firstName;
    private String lastName;
    private String personalId;
    private String mail;
    private Date birthday;
    private String password;
    private String rePass;

}
