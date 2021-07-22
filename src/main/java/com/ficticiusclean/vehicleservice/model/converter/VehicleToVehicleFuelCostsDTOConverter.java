/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model.converter;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleFuelCostsDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author pedro
 */
@Component
public class VehicleToVehicleFuelCostsDTOConverter implements Converter<Vehicle, VehicleFuelCostsDTO> {

    @Override
    public VehicleFuelCostsDTO convert(Vehicle vehicle) {
        VehicleFuelCostsDTO vehicleFuelCostsDTO = new VehicleFuelCostsDTO();
        vehicleFuelCostsDTO.setName(vehicle.getName());
        vehicleFuelCostsDTO.setManufactureYear(vehicle.getManufactureDate().getYear());
        vehicleFuelCostsDTO.setBrand(vehicle.getBrand());
        vehicleFuelCostsDTO.setName(vehicle.getName());
        vehicleFuelCostsDTO.setModel(vehicle.getModel());
        return vehicleFuelCostsDTO;
    }

}
