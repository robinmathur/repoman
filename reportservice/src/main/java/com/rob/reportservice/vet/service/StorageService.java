package com.rob.reportservice.vet.service;

import com.rob.reportservice.vet.exceptions.FileStorageException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.Set;


public interface StorageService {
    void init();
    Set<Path> store(Set<MultipartFile> files) throws FileStorageException;
    void delete(Path filePath) throws FileStorageException;
    void deleteAll() throws FileStorageException;
}
