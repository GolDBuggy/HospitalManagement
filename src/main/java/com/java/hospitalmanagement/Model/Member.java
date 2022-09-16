package com.java.hospitalmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "personal_identification_number")
    private String personalId;

    @Column(name = "mail")
    private String mail;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "passw")
    private String password;

    @Column(name = "roles")
    private String roles;

    @Column(name = "activity")
    private boolean activity;
}
