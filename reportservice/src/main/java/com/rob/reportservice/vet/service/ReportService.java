package com.rob.reportservice.vet.service;

import com.rob.reportservice.vet.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Set;

@Service
public class ReportService {

    @Autowired
    private StorageService storageService;

    @Autowired
    private ReportMergerFactory reportMergerFactory;


    public Path mergeReport(Report report) {
        Set<Path> paths = storageService.store(report.getFiles());
        ReportMerger reportMerger = reportMergerFactory.getInstance(report.getReportType());
        Path merge = reportMerger.merge(paths);
        return merge;
    }
}
