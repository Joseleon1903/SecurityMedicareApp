package com.spring.security.medi.care.app.commons.exception;

public class ResourceAlreadyExistException extends RuntimeException{

    public ResourceAlreadyExistException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ResourceAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }

    public static void  launchThrowExcepction(String message) throws ResourceAlreadyExistException {
        throw new ResourceAlreadyExistException(message);
    }
}
