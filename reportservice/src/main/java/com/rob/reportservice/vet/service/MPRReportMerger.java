package com.rob.reportservice.vet.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MPRReportMerger implements ReportMerger {
    @Override
    public Path merge(Set<Path> files) {
        List<Path> paths = new ArrayList<>();
        paths.addAll(files);
        return paths.get(0);
    }
}
