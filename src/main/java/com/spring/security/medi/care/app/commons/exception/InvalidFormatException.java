package com.spring.security.medi.care.app.commons.exception;

public class InvalidFormatException extends RuntimeException{

    public InvalidFormatException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InvalidFormatException(String errorMessage) {
        super(errorMessage);
    }

    public static void  launchThrowExcepction(String message) throws ResourceAlreadyExistException {
        throw new InvalidFormatException(message);
    }
}
