package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.ReportDto;
import com.java.hospitalmanagement.Model.Report;
import com.java.hospitalmanagement.Repository.ReportRepo;
import com.java.hospitalmanagement.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/save")
    public ResponseEntity<String> saveReport(@RequestBody ReportDto reportDto, Principal principal){
        reportService.save(reportDto,principal);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Report saved successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReportDto>> allReport(Principal principal){
        return ResponseEntity.status(HttpStatus.OK).body(reportService.getReports(principal));
    }

}
