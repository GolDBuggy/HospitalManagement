package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine,String> {
}
