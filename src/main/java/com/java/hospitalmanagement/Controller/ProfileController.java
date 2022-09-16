package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Model.Profile;
import com.java.hospitalmanagement.Service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/save")
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile, Principal principal){
        profileService.save(profile,principal);
        return ResponseEntity.accepted().body(profile);
    }

}
