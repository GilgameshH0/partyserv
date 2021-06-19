package com.miracle.partyserv.exception;

import com.miracle.partyserv.model.PhErrorType;

public class PhException extends Exception {
    private final PhErrorType phErrorType;
    private final String message;

    public PhException(PhErrorType phErrorType, String message) {
        this.phErrorType = phErrorType;
        this.message = message;
    }

    public PhErrorType getPhErrorType() {
        return phErrorType;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
