package com.rob.reportservice.vet.controller;

import com.rob.reportservice.vet.model.Report;
import com.rob.reportservice.vet.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/report")
public class ReportController {
    Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @PostMapping("merge")
    public ResponseEntity<Resource> mergeReports(@ModelAttribute Report report) throws IOException {
        logger.info("Report Title {}",report.getReportTitle());
        logger.info("Date from {}",report.getDateFrom());
        logger.info("Date To {}",report.getDateTo());
        report.getFiles().forEach(multipartFile -> logger.info("File Name {}",multipartFile.getOriginalFilename()));
        Path mergedReportPath = reportService.mergeReport(report);
        Resource resource = new UrlResource(mergedReportPath.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(Files.size(mergedReportPath))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
