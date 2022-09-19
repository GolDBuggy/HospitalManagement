package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Model.Profile;
import com.java.hospitalmanagement.Repository.ProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepo profileRepo;
    private final MemberService memberService;


    public void save(Profile profile, Principal principal){
        profile.setId(UUID.randomUUID().toString());
        profile.setMember(memberService.getByPersonalId(principal.getName()));
        profileRepo.save(profile);
    }


    public Profile getProfile(Principal principal){
        return memberService.getByPersonalId(principal.getName()).getProfile();
    }

}
