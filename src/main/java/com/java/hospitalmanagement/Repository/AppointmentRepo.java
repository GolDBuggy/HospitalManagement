package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

    boolean existsAppointmentByStartTimeAndEndTime(LocalDateTime startTime,LocalDateTime endTime);
}
