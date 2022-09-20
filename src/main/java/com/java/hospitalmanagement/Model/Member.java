package com.java.hospitalmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @OneToOne(mappedBy = "member")
    private Profile profile;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Barcode> barcodes;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MedicalAnalysis> medicalAnalyses;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Disease> diseases;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<EmergencyNote> emergencyNotes;


}
