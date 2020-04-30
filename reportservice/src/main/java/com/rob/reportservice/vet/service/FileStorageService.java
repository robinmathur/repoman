package com.rob.reportservice.vet.service;

import com.rob.reportservice.vet.config.StorageConfig;
import com.rob.reportservice.vet.exceptions.FileStorageException;
import com.rob.reportservice.vet.exceptions.StorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

@Service
public class FileStorageService implements StorageService {

    Logger logger = LoggerFactory.getLogger(FileStorageService.class);

    private static Path basePath;

    @Autowired
    public FileStorageService(StorageConfig storageConfig){
        basePath = storageConfig.getBasePath();
    }

    @Override
    @PostConstruct
    public void init() {
        if(Files.notExists(basePath)){
            try {
                Files.createDirectories(basePath);
            } catch (IOException e) {
                throw new StorageException("Could not initialized storage location", e);
            }
        }
    }

    @Override
    public Set<Path> store(Set<MultipartFile> files) throws FileStorageException {
        HashSet<Path> paths = new HashSet<Path>();
        try {
            Path tempDirectory = Files.createTempDirectory(basePath, "");
            Path filePath;
            for(MultipartFile file: files){
                paths.add(filePath = tempDirectory.resolve(file.getOriginalFilename()));
                file.transferTo(filePath);
            }
        } catch (IOException e) {
            throw new FileStorageException("Failed to store files",e);
        }
        return paths;
    }

    @Override
    public void delete(Path filePath) throws FileStorageException {
        try {
            FileSystemUtils.deleteRecursively(filePath);
        } catch (IOException e) {
            throw new FileStorageException("Failed to delete files at path "+filePath,e);
        }
    }

    @Override
    public void deleteAll() throws FileStorageException {
        try {
            FileSystemUtils.deleteRecursively(basePath);
        } catch (IOException e) {
            throw new FileStorageException("Failed to delete files at path "+basePath,e);
        }
    }
}
