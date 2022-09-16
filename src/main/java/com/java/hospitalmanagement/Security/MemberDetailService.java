package com.java.hospitalmanagement.Security;

import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService{

    private final MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String personalId) throws UsernameNotFoundException {
        Optional<Member> member=repository.findByPersonalId(personalId);
        return member.map(MemberDetails::new).orElseThrow(() -> new UsernameNotFoundException("Member not found!"));
    }
}
