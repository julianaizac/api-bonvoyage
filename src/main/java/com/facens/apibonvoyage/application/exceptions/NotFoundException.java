package com.facens.apibonvoyage.application.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends GenericException{

    public NotFoundException(String mensagem, HttpStatus httpStatus) {
        super(mensagem, httpStatus);
    }

}
