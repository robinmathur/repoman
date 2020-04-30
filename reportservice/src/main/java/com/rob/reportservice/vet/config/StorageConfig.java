package com.rob.reportservice.vet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@ConfigurationProperties(prefix = "storage")
public class StorageConfig {

    private Path basePath;
    private String reportPath;
    private String templatePath;

    public Path getBasePath() {
        return basePath;
    }

    public void setBasePath(Path basePath) {
        this.basePath = basePath;
    }

    public Path getReportPath() {
        return basePath.resolve(reportPath);
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public Path getTemplatePath() {
        return basePath.resolve(templatePath);
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }
}
