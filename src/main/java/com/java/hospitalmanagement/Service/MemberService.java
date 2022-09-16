package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.MemberDto;
import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder encoder;

    private static String DEFAULT="ROLE_MEMBER";


    public List<Member> getAll(){
        return memberRepository.findAll();
    }


    public Member getByEmail(String personalId){
        return memberRepository.findByPersonalId(personalId).get();
    }

    public void save(MemberDto memberDto){
        checkPass(memberDto);
        memberRepository.save(mapMember(memberDto));
    }

    private Member mapMember(MemberDto memberDto){
        memberDto.setPassword(encoder.encode(memberDto.getPassword()));
        Member member=modelMapper.map(memberDto,Member.class);
        member.setId(UUID.randomUUID().toString());
        member.setActivity(true);
        member.setRoles(DEFAULT);
        return member;
    }


    private void checkPass(MemberDto memberDto){
        if(!memberDto.getPassword().equals(memberDto.getRePass()))
            throw new RuntimeException("Passwords must be equals!");
    }
}
