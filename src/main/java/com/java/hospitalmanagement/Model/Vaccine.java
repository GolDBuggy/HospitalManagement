package com.java.hospitalmanagement.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vaccine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private long id;

    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "vaccine_company")
    private String company;

    @Column(name = "vaccine_dose")
    private int dose;

    @Column(name = "vaccine_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


}
