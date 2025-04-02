package com.ormexample.demo.exception;

import org.springframework.http.HttpStatus;

public class EmpleadoExceptions {
    public static class EmpleadoNotFoundException extends ApiException {
        public EmpleadoNotFoundException(String email) {
            super("Email " + email + " is not found.", HttpStatus.NOT_FOUND);
        }
    }
}
