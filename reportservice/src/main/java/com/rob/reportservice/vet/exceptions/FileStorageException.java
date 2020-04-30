package com.rob.reportservice.vet.exceptions;

import java.io.IOException;

public class FileStorageException extends StorageException {

    public FileStorageException(String message, IOException e) {
        super(message, e);
    }
}
