package com.facens.apibonvoyage.application.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefaultError {

    private Integer status;
    private String message;

}
