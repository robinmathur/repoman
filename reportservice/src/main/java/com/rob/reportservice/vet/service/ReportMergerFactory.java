package com.rob.reportservice.vet.service;

import com.rob.reportservice.vet.constants.ReportType;

import java.util.Map;

public class ReportMergerFactory {
    private Map<ReportType, ReportMerger> mergerMap;

    public ReportMergerFactory(Map<ReportType, ReportMerger> mergerMap){
        this.mergerMap= mergerMap;
    }

    public ReportMerger getInstance(ReportType reportType){
        return mergerMap.get(reportType);
    }

    public Map<ReportType, ReportMerger> getMergerMap() {
        return mergerMap;
    }
}
