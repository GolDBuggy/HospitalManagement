package com.java.hospitalmanagement.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestTable {

    @Id
    @Column(name = "request_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "analysis_name")
    private String analysisName;

    @Column(name = "request_time")
    private LocalDateTime sendTime;
}
