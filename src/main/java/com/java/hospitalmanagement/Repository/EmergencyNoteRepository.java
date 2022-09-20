package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.EmergencyNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyNoteRepository extends JpaRepository<EmergencyNote,Long> {
}
