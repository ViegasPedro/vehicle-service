/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.resource;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleDTO;
import com.ficticiusclean.vehicleservice.service.VehicleService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleResource {
    
    @Autowired
    private VehicleService vehicleService;
    
    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("ping!");
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<VehicleDTO> saveVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicleDTO));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
    
    @PutMapping("/{id}")
    public  ResponseEntity<VehicleDTO> updateVehicle(
            @PathVariable("id") Long id, 
            @Valid @RequestBody VehicleDTO vehicleDTO){
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDTO));
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void deleteVehicle(@PathVariable("id") Long id){
        vehicleService.deleteVehicle(id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable("id") Long id){
        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }
}
