package com.java.hospitalmanagement.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "disease")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disease {

    @Id
    @Column(name = "disease_id")
    private String id;

    @Column(name = "disease_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;


}
