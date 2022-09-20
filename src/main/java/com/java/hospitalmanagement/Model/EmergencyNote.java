package com.java.hospitalmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_note")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "topic")
    private String topic;

    @Column(name = "emergency_message")
    private String emergencyMessage;

    @Column(name = "note_date")
    private LocalDateTime date;
}
