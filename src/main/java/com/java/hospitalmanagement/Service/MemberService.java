package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;


    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public void save(Member member){
        member.setId(UUID.randomUUID().toString());
        member.setPassword(encoder.encode(member.getPassword()));
        memberRepository.save(member);
    }
}
