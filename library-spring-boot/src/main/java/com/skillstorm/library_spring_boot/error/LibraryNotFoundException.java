package com.skillstorm.library_spring_boot.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException(String message) {
        super(message);
    }
}