package com.java.hospitalmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medicine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @Column(name = "medicine_id")
    private String id;

    @Column(name = "medicine_name")
    private String name;

    @Column(name = "prescriptions")
    private String prescriptions;

    @Column(name = "expire_date")
    private Date expireDate;

    @ManyToMany
    @JoinTable(name = "barcode_medicine",joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "barcode_id"))
    @JsonIgnore
    private List<Barcode> barcodes;

}
