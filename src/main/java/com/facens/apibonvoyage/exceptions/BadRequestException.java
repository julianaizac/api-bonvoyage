package com.facens.apibonvoyage.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestException extends GenericException {

    public BadRequestException(String mensagem, HttpStatus httpStatus) {
        super(mensagem, httpStatus);
    }

}
