package com.rob.reportservice.vet.config;

import com.rob.reportservice.vet.constants.ReportType;
import com.rob.reportservice.vet.service.MPRReportMerger;
import com.rob.reportservice.vet.service.ParcheeReportMerger;
import com.rob.reportservice.vet.service.ReportMerger;
import com.rob.reportservice.vet.service.ReportMergerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public ReportMergerFactory reportMergerRepo(){
        Map<ReportType, ReportMerger> mergerMap =  new HashMap<>();
        mergerMap.put(ReportType.TYPE1, new MPRReportMerger());
        mergerMap.put(ReportType.TYPE2,new ParcheeReportMerger());
        return new ReportMergerFactory(mergerMap);
    }
}
