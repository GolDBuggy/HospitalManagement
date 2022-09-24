package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface VaccineRepo extends JpaRepository<Vaccine,Long> {

    boolean existsByMemberAndNameAndDose(Member member, String name,int dose);
}
