package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.NoteDto;
import com.java.hospitalmanagement.Model.EmergencyNote;
import com.java.hospitalmanagement.Service.EmergencyNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class EmergencyNoteController {

    private final EmergencyNoteService noteService;

    @PostMapping("/save")
    public ResponseEntity<String> saveNote(@RequestBody EmergencyNote emergencyNote, Principal principal){
        noteService.save(emergencyNote, principal);
        return ResponseEntity.status(HttpStatus.OK).body(emergencyNote.getEmergencyMessage());
    }

    @GetMapping("/{personalId}")
    public ResponseEntity<List<NoteDto>> getMemberNotes(@PathVariable String personalId){
        return ResponseEntity.accepted().body(noteService.getNoteByPersonalId(personalId));
    }

    @GetMapping("/my")
    public ResponseEntity<List<NoteDto>> getMyNotes(Principal principal){
        return ResponseEntity.accepted().body(noteService.getNoteByPersonalId(principal.getName()));
    }


}
