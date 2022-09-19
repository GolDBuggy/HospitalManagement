package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Model.RequestTable;
import com.java.hospitalmanagement.Repository.RequestTableRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestTableService {

    private final RequestTableRepo tableRepo;

    public void save(RequestTable requestTable){
        tableRepo.save(requestTable);
    }



}
