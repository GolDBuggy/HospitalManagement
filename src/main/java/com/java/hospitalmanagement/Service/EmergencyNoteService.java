package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.NoteDto;
import com.java.hospitalmanagement.Model.EmergencyNote;
import com.java.hospitalmanagement.Repository.EmergencyNoteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmergencyNoteService {

    private final EmergencyNoteRepository noteRepository;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    public void save(EmergencyNote emergencyNote, Principal principal){
        emergencyNote.setMember(memberService.getByPersonalId(principal.getName()));
        emergencyNote.setDate(LocalDateTime.now());
        noteRepository.save(emergencyNote);
    }


    public List<NoteDto> getNoteByPersonalId(String personalId){
        return memberService.getByPersonalId(personalId).getEmergencyNotes().stream().map(e-> modelMapper.map(e,NoteDto.class)).collect(Collectors.toList());
    }

}
