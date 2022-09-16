package com.java.hospitalmanagement.Repository;

import com.java.hospitalmanagement.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile,String> {
}
