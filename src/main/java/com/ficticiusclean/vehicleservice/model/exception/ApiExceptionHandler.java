/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ficticiusclean.vehicleservice.model.exception;

import com.ficticiusclean.vehicleservice.model.StandardError;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created 21/07/2021
 *
 * @author Pedro Viegas <pedro_viegas@live.com>
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<StandardError> handleVehicleNotFound(VehicleNotFoundException vehicleNotFoundException){
        StandardError standardError = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), LocalDateTime.now(), vehicleNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(standardError);
    }
}
