package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Exception.TimeException;
import com.java.hospitalmanagement.Model.Appointment;
import com.java.hospitalmanagement.Model.Doctor;
import com.java.hospitalmanagement.Repository.AppointmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final HospitalService hospitalService;
    private final ClinicService clinicService;
    private final MemberService memberService;
    private final DoctorService doctorService;


    private static Logger logger=Logger.getLogger(AppointmentService.class.getName());



    public void save(String hospital, String clinic, String name, String start, String end, Principal principal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime=LocalDateTime.parse(start,formatter);
        LocalDateTime endTime=LocalDateTime.parse(end,formatter);
        checkTime(startTime,endTime);
        Appointment appointment=Appointment.builder().hospital(hospitalService.getByName(hospital)).
                member(memberService.getByPersonalId(principal.getName())).
                clinic(clinicService.getByClinicNameAndHospital(clinic, hospitalService.getByName(hospital))).
                doctor(getByName(name)).startTime(startTime).endTime(endTime).build();

        appointmentRepo.save(appointment);
    }

    private void checkTime(LocalDateTime startTime,LocalDateTime endTime){
        int timeHour=endTime.getHour()-startTime.getHour();
        double totalTimeMinute=Math.abs(endTime.getMinute()-startTime.getMinute());
        boolean dateControl=(startTime.getDayOfMonth()-endTime.getDayOfMonth()) ==0;
        boolean workingHour=(endTime.getHour()>=8 && endTime.getHour()<=17) && (startTime.getHour()>=8 && startTime.getHour() <=17);
        boolean appointmentTime=((timeHour==0 || timeHour==1) && totalTimeMinute<=30.0);
        if (!(workingHour && appointmentTime && dateControl))
            throw new TimeException("Time range must be entered correctly! ");
    }


    private Doctor getByName(String doctorName){
        String[] name=doctorName.split("\\s+");

        if(name.length==3){
            String firstName=name[0]+" "+name[1];
            return doctorService.findByDoctorName(firstName,name[2]);
        }

        return doctorService.findByDoctorName(name[0],name[1]);
    }


}
