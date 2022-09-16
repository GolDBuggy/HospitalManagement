package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.MemberDto;
import com.java.hospitalmanagement.Model.Member;
import com.java.hospitalmanagement.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping("/save")
    public ResponseEntity<?> saveMember(@RequestBody MemberDto memberDto){
        service.save(memberDto);
        return  ResponseEntity.accepted().body(memberDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Member>> all(){
        return ResponseEntity.ok(service.getAll());
    }


}
