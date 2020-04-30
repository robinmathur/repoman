package com.rob.reportservice.vet.exceptions;

import java.io.IOException;

public class StorageException extends RuntimeException {
    public StorageException(String message, IOException e) {
        super(message,e);
    }
}
