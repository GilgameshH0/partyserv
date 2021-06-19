package com.miracle.partyserv.exception;

import com.miracle.partyserv.model.PhResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {PhException.class})
    public ResponseEntity<?> phExceptionHandler(PhException phException) {
        switch (phException.getPhErrorType()) {
            case UsernameAlreadyInUse -> {
                return new ResponseEntity<>(new PhResponse("UsernameAlreadyInUse", "Username already in use."), HttpStatus.CONFLICT);
            }
            case EmailAlreadyInUse -> {
                return new ResponseEntity<>(new PhResponse("EmailAlreadyInUse", "Email already in use."), HttpStatus.CONFLICT);
            }
            default -> throw new IllegalStateException("Unexpected type: " + phException.getPhErrorType());
        }
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity<?> badCredentialsExceptionHandler() {
        return new ResponseEntity<>(new PhResponse("BadCredentials", "Username or password are not correct."), HttpStatus.UNAUTHORIZED);
    }
}
