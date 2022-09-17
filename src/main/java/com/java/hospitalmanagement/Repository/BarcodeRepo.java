package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Barcode;
import com.java.hospitalmanagement.Model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodeRepo extends JpaRepository<Barcode,String> {
}
