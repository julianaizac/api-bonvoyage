package com.facens.apibonvoyage.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConversionError(MethodArgumentTypeMismatchException ex) {

        String mensagem = "Formato inválido: " + ex.getName();
        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), mensagem);
        return ResponseEntity.status(error.getStatus()).body(error);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequestException(BadRequestException exception){
        DefaultError error = new DefaultError(exception.getStatus().value(), exception.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception){
        DefaultError error = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

}