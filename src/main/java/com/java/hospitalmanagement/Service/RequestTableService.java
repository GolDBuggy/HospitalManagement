package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.AnalysisRequestDto;
import com.java.hospitalmanagement.Model.RequestTable;
import com.java.hospitalmanagement.Repository.RequestTableRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestTableService {

    private final RequestTableRepo tableRepo;
    private final ModelMapper modelMapper;

    public void save(RequestTable requestTable){
        tableRepo.save(requestTable);
    }


    public List<AnalysisRequestDto> getAll() {
        List<AnalysisRequestDto> analysisRequestDtos=tableRepo.findAll(Sort.by("sendTime")).stream().map(e -> modelMapper.map(e,AnalysisRequestDto.class)).collect(Collectors.toList());
       return analysisRequestDtos;
    }
}
