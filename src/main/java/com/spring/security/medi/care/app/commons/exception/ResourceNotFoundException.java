package com.spring.security.medi.care.app.commons.exception;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public static void  launchThrowExcepction(String message) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(message);
    }
}