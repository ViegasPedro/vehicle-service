/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.service;

import com.ficticiusclean.vehicleservice.model.CostSimulationDTO;
import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleResponse;
import com.ficticiusclean.vehicleservice.model.exception.VehicleNotFoundException;
import java.util.ArrayList;
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
    
    public List<VehicleResponse> simulateCosts(CostSimulationDTO costSimulation){
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        if(vehicles.isEmpty())
            throw new VehicleNotFoundException("Não existem veículos na base");
        
        List<VehicleResponse> vehiclesResponse = new ArrayList<>();
        
        for(Vehicle vehicle : vehicles){
            double cityFuelCostSimulation = 0, highwayFuelCostSimulation = 0,
                    cityFuelAmountSimulation = 0, highwayFuelAmountSimulation = 0; 
            if(costSimulation.getTotalKmCidade() > 0.0){
                cityFuelCostSimulation = vehicle.simulateCityFuelCost(costSimulation.getPrecoGasolina(), costSimulation.getTotalKmCidade());
                cityFuelAmountSimulation = vehicle.simulatecityFuelAmout(costSimulation.getTotalKmCidade());
            }
            if(costSimulation.getTotalKmRodovia()> 0.0){
                highwayFuelCostSimulation = vehicle.simulateHighwayFuelCost(costSimulation.getPrecoGasolina(),costSimulation.getTotalKmRodovia());
                highwayFuelAmountSimulation = vehicle.simulateHighwayFuelAmout(costSimulation.getTotalKmRodovia());
            }
            vehiclesResponse.add(
                    new VehicleResponse(vehicle.getNome(), 
                            vehicle.getMarca(), 
                            vehicle.getModelo(), 
                            vehicle.getDataFabricacao().getYear() + 1900, 
                            cityFuelAmountSimulation + highwayFuelAmountSimulation,
                            highwayFuelCostSimulation + cityFuelCostSimulation));
        }
        return vehiclesResponse;
    }
}
