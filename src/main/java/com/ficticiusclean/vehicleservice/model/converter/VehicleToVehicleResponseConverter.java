/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model.converter;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author pedro
 */
@Component
public class VehicleToVehicleResponseConverter implements Converter<Vehicle, VehicleResponse> {

    @Override
    public VehicleResponse convert(Vehicle vehicle) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setName(vehicle.getName());
        vehicleResponse.setManufactureYear(vehicle.getManufactureDate().getYear());
        vehicleResponse.setBrand(vehicle.getBrand());
        vehicleResponse.setName(vehicle.getName());
        vehicleResponse.setModel(vehicle.getModel());
        return vehicleResponse;
    }

}
