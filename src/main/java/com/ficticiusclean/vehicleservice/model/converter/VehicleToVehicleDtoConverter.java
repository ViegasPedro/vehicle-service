/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model.converter;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author pedro
 */
@Component
public class VehicleToVehicleDtoConverter implements Converter<Vehicle, VehicleDTO> {

    @Override
    public VehicleDTO convert(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setAvaregeHighwayConsumption(vehicle.getAvaregeHighwayConsumption());
        vehicleDTO.setAverageCityConsumption(vehicle.getAverageCityConsumption());
        vehicleDTO.setManufactureDate(vehicle.getManufactureDate());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setName(vehicle.getName());
        return vehicleDTO;
    }
    
}
