package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
}
