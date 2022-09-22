package com.java.hospitalmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.print.Doc;
import java.util.List;

@Entity
@Table(name = "clinic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {

    @Id
    @Column(name = "clinic_id")
    private String id;

    @Column(name = "clinic_name")
    private String clinicName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hospital_clinic",joinColumns = @JoinColumn(name = "clinic_id"),
                                        inverseJoinColumns = @JoinColumn(name = "hospital_id"))
    private List<Hospital> hospitals;

    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctors;

}
