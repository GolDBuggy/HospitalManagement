package com.java.hospitalmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

    private MemberInformationDto member;
    private String topic;
    private String emergencyMessage;
    private LocalDateTime date;
}
