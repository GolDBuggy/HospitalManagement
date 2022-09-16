package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,String> {

    Optional<Member> findByPersonalId(String personalId);
}
