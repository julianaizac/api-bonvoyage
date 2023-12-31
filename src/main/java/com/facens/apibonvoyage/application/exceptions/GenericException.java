package com.facens.apibonvoyage.application.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {

    public String message;
    public HttpStatus status;

    public GenericException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

}
