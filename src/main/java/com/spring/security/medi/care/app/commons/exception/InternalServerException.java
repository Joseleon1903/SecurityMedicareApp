package com.spring.security.medi.care.app.commons.exception;

public class InternalServerException extends Exception{

    public InternalServerException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InternalServerException(String errorMessage) {
        super(errorMessage);
    }

    public static void  launchThrowExcepction(String message) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(message);
    }

}