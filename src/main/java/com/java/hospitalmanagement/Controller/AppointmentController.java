package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Model.Appointment;
import com.java.hospitalmanagement.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    private static Logger logger=Logger.getLogger(AppointmentController.class.getName());

    @PostMapping("/save")
    public ResponseEntity<String> create(@RequestParam("hospital") String hospital,
                                         @RequestParam("clinic") String clinic,
                                         @RequestParam("doctor") String name,
                                         @RequestParam("start") String start,
                                         @RequestParam("end") String end,
                                         Principal principal){
        appointmentService.save(hospital,clinic,name,start,end,principal);


       return ResponseEntity.accepted().body("ss");
    }
}
