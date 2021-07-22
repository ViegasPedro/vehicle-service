/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.service;

import com.ficticiusclean.vehicleservice.model.CostSimulationDTO;
import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleResponse;
import com.ficticiusclean.vehicleservice.model.converter.VehicleToVehicleResponseConverter;
import com.ficticiusclean.vehicleservice.model.exception.InvalidOperationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class CostSimulationService {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleToVehicleResponseConverter vehicleConverter;

    public List<VehicleResponse> simulateCosts(CostSimulationDTO costSimulation) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        if (vehicles.isEmpty()) {
            throw new InvalidOperationException("Não existem veículos na base");
        }

        List<VehicleResponse> vehicleResponseList = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            vehicleResponseList.add(createVehicleWithFuelData(vehicle, costSimulation));
        }
        Collections.sort(vehicleResponseList);
        return vehicleResponseList;
    }

    private VehicleResponse createVehicleWithFuelData(Vehicle vehicle, CostSimulationDTO costSimulation) {
        double cityFuelCostSimulation = 0,
                highwayFuelCostSimulation = 0,
                cityFuelAmountSimulation = 0,
                highwayFuelAmountSimulation = 0;

        if (costSimulation.getTotalDistanceInCity() > 0) {
            cityFuelCostSimulation = vehicle.simulateCityFuelCost(costSimulation.getFuelPrice(), costSimulation.getTotalDistanceInCity());
            cityFuelAmountSimulation = vehicle.simulatecityFuelAmout(costSimulation.getTotalDistanceInCity());
        }
        if (costSimulation.getTotalDistanceInHighway() > 0) {
            highwayFuelCostSimulation = vehicle.simulateHighwayFuelCost(costSimulation.getFuelPrice(), costSimulation.getTotalDistanceInHighway());
            highwayFuelAmountSimulation = vehicle.simulateHighwayFuelAmout(costSimulation.getTotalDistanceInHighway());
        }
        VehicleResponse vehicleResponse = vehicleConverter.convert(vehicle);
        vehicleResponse.setTotalFuelConsumed(cityFuelAmountSimulation + highwayFuelAmountSimulation);
        vehicleResponse.setTotalFuelCost(cityFuelCostSimulation + highwayFuelCostSimulation);

        return vehicleResponse;
    }

}
