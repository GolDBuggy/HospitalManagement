package com.java.hospitalmanagement.Controller;

import com.java.hospitalmanagement.Dto.AnalysisRequestDto;
import com.java.hospitalmanagement.Service.RequestTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class RequestTableController {

    private final RequestTableService tableService;

    @GetMapping("/analysis")
    public ResponseEntity<List<AnalysisRequestDto>> getAll(){
        return ResponseEntity.ok(tableService.getAll());
    }
}
