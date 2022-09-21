package com.java.hospitalmanagement.Service;

import com.java.hospitalmanagement.Dto.ReportDto;
import com.java.hospitalmanagement.Model.Report;
import com.java.hospitalmanagement.Repository.ReportRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepo reportRepo;
    private final DoctorService doctorService;
    private final ModelMapper modelMapper;
    private final MemberService memberService;

    public void save(ReportDto reportDto, Principal principal){
        Report report=Report.builder().id(UUID.randomUUID().toString()).
                        doctor(doctorService.getByPersonalId(principal.getName())).
                        reportType(reportDto.getReportType()).date(LocalDate.now()).
                        member(memberService.getByPersonalId(reportDto.getMember().getPersonalId())).build();
        reportRepo.save(report);
    }

    public List<ReportDto> getReports(Principal principal){
        return memberService.getByPersonalId(principal.getName()).getReports().stream().map(e -> modelMapper.map(e,ReportDto.class)).collect(Collectors.toList());
    }

}
