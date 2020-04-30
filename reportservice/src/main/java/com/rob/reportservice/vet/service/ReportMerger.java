package com.rob.reportservice.vet.service;

import java.nio.file.Path;
import java.util.Set;

public interface ReportMerger {

    Path merge(Set<Path> files);
}
