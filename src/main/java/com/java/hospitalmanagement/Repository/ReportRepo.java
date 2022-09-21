package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report,String> {
}
