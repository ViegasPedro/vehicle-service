/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ficticiusclean.vehicleservice.model.validation.CostSimulation;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author pedro
 */
@CostSimulation
public class CostSimulationDTO {

    @PositiveOrZero(message = "O campo \"precoGasolina\" deve ser maior ou igual a 0")
    @JsonProperty("precoGasolina")
    private double fuelPrice;
    @JsonProperty("totalKmCidade")
    private double totalDistanceInCity;
    @JsonProperty("totalKmRodovia")
    private double totalDistanceInHighway;

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public double getTotalDistanceInCity() {
        return totalDistanceInCity;
    }

    public void setTotalDistanceInCity(double totalDistanceInCity) {
        this.totalDistanceInCity = totalDistanceInCity;
    }

    public double getTotalDistanceInHighway() {
        return totalDistanceInHighway;
    }

    public void setTotalDistanceInHighway(double totalDistanceInHighway) {
        this.totalDistanceInHighway = totalDistanceInHighway;
    }
    
    
}
