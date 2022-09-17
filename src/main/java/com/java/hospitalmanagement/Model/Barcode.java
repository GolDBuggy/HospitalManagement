package com.java.hospitalmanagement.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "barcode")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Barcode {

    @Id
    @Column(name = "barcode_id")
    private String id;

    @Column(name = "disease")
    private String disease;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "barcode_medicine",joinColumns = @JoinColumn(name = "barcode_id"),
                        inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicines;


}
