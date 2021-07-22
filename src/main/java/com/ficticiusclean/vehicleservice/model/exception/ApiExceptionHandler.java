/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model.exception;

import com.ficticiusclean.vehicleservice.model.StandardError;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

/**
 * Created 21/07/2021
 *
 * @author Pedro Viegas <pedro_viegas@live.com>
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<StandardError> handleVehicleNotFound(VehicleNotFoundException vehicleNotFoundException) {
        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), Arrays.asList(vehicleNotFoundException.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
    
    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<StandardError> handleInvalidOperation(InvalidOperationException ex) {
        StandardError standardError = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), LocalDateTime.now(), Arrays.asList(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errorMessages = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), errorMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), Arrays.asList("Body da requisição inválido"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        StandardError standardError = new StandardError(HttpStatus.METHOD_NOT_ALLOWED.value(), LocalDateTime.now(), Arrays.asList("Método da requisição não suportado"));
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(standardError);
    }
    
    
}
