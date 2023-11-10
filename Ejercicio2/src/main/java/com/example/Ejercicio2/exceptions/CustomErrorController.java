package com.example.Ejercicio2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class CustomErrorController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Mensaje", ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(ConsumoExcedidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConsumoExcedidoException(ConsumoExcedidoException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Mensaje", ex.getMessage());
        return errorResponse;
    }
}
