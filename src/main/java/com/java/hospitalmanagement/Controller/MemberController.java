package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/save")
    public Member saveMember(@RequestBody Member member){
        service.save(member);
        return member;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Member>> all(){
        return ResponseEntity.ok(service.getAll());
    }
}
