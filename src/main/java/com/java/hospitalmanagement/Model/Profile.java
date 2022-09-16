package com.java.hospitalmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name = "member_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @Column(name = "profile_id")
    private String id;

    @OneToOne
    @JoinColumn(name ="member_id")
    @JsonIgnore
    private Member member;

    @Column(name = "phone")
    private String phone;

    @Column(name = "age")
    private int age;

    @Column(name = "height")
    private double height;

    @Column(name = "kilo")
    private double kilo;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "birthplace")
    private String birthplace;



}
