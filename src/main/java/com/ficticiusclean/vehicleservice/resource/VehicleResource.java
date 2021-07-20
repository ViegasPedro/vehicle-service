/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.resource;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.service.VehicleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleResource {
    
    @Autowired
    private VehicleService vehicleService;
    
    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("ping!");
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVehicle(@RequestBody Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
}
