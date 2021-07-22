/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.service;

import com.ficticiusclean.vehicleservice.model.CostSimulationDTO;
import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleFuelCostsDTO;
import com.ficticiusclean.vehicleservice.model.converter.VehicleToVehicleFuelCostsDTOConverter;
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
    private VehicleToVehicleFuelCostsDTOConverter vehicleConverter;

    public List<VehicleFuelCostsDTO> simulateCosts(CostSimulationDTO costSimulation) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        if (vehicles.isEmpty()) {
            throw new InvalidOperationException("Não existem veículos na base");
        }

        List<VehicleFuelCostsDTO> vehicleFuelCostsDTOList = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            vehicleFuelCostsDTOList.add(createVehicleWithFuelData(vehicle, costSimulation));
        }
        Collections.sort(vehicleFuelCostsDTOList);
        return vehicleFuelCostsDTOList;
    }

    private VehicleFuelCostsDTO createVehicleWithFuelData(Vehicle vehicle, CostSimulationDTO costSimulation) {
        double cityFuelCostSimulation = 0,
                highwayFuelCostSimulation = 0,
                cityFuelAmountSimulation = 0,
                highwayFuelAmountSimulation = 0;

        //apenas calcula os gastos na cidade se foi informado a distancia percorrida na cidade
        if (costSimulation.getTotalDistanceInCity() > 0) {
            cityFuelCostSimulation = (costSimulation.getTotalDistanceInCity() / vehicle.getAverageCityConsumption()) * costSimulation.getFuelPrice();
            cityFuelAmountSimulation = costSimulation.getTotalDistanceInCity() / vehicle.getAverageCityConsumption();
        }
        //apenas calcula os gastos na rodovia se foi informado a distanria percorrida na rodovia
        if (costSimulation.getTotalDistanceInHighway() > 0) {
            highwayFuelCostSimulation = (costSimulation.getTotalDistanceInHighway() / vehicle.getAvaregeHighwayConsumption()) * costSimulation.getFuelPrice();
            highwayFuelAmountSimulation = costSimulation.getTotalDistanceInHighway() / vehicle.getAvaregeHighwayConsumption();
        }
        VehicleFuelCostsDTO vehicleFuelCostsDTO = vehicleConverter.convert(vehicle);
        vehicleFuelCostsDTO.setTotalFuelConsumed(cityFuelAmountSimulation + highwayFuelAmountSimulation);
        vehicleFuelCostsDTO.setTotalFuelCost(cityFuelCostSimulation + highwayFuelCostSimulation);

        return vehicleFuelCostsDTO;
    }

}
