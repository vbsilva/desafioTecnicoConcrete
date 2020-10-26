package com.vbas.desafioTecnicoConcrete.exception;

import org.springframework.http.HttpStatus;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 4064344914779422857L;

    public UserServiceException(String message) {
        super(message);
    }
}
