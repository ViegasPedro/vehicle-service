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
public class VehicleDtoToVehicleConverter implements Converter<VehicleDTO, Vehicle>{

    @Override
    public Vehicle convert(VehicleDTO vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setAvaregeHighwayConsumption(vehicleDto.getAvaregeHighwayConsumption());
        vehicle.setAverageCityConsumption(vehicleDto.getAverageCityConsumption());
        vehicle.setManufactureDate(vehicleDto.getManufactureDate());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setName(vehicleDto.getName());
        return vehicle;
    }
    
}
