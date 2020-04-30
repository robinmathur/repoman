package com.rob.reportservice;

import com.rob.reportservice.vet.config.StorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({StorageConfig.class})
public class ReportserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportserviceApplication.class, args);
    }

}
