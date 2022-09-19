package com.java.hospitalmanagement.Listener;


import com.java.hospitalmanagement.Dto.AnalysisRequestDto;
import com.java.hospitalmanagement.Model.RequestTable;
import com.java.hospitalmanagement.Service.RequestTableService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class AnalysisListener {



    private static Logger logger=Logger.getLogger(AnalysisListener.class.getName());

    @KafkaListener(topics = "analysis_request",groupId = "doctor_message")
    private void listener(List<AnalysisRequestDto> analysisRequestDto){
        logger.info(analysisRequestDto+" ");
    }


}
