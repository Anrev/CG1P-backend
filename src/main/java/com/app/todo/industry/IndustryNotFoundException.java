package com.app.todo.industry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IndustryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IndustryNotFoundException(Long industryId) {
        super("Industry with ID: " + industryId + " is not found!");
    }

    public IndustryNotFoundException(String industryName) {
        super("Industry " + industryName + " is not found!");
    }
}