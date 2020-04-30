package com.rob.reportservice.vet.model;

import com.rob.reportservice.vet.constants.ReportType;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Report {
    private String reportTitle;
    private ReportType reportType;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Set<MultipartFile> files = new HashSet<>();

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Set<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(Set<MultipartFile> files) {
        this.files = files;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }
}
