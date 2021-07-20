/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.service;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.repository.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    public void saveVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
    
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
}
