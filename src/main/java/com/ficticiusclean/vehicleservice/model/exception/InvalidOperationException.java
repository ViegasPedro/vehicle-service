/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ficticiusclean.vehicleservice.model.exception;

/**
 * Created 22/07/2021
 *
 * @author Pedro Viegas <pedro_viegas@live.com>
 */
public class InvalidOperationException extends RuntimeException{

    public InvalidOperationException(String message) {
        super(message);
    }

}
