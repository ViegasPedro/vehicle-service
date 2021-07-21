/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created 21/07/2021
 *
 * @author Pedro Viegas <pedro_viegas@live.com>
 */
public class VehicleTest {

    @Test
    public void simulateCityFuelCost() {
        Vehicle vehicle = new Vehicle();
        vehicle.setConsumoMedioCidade(10);

        double cityFuelCost = vehicle.simulateCityFuelCost(2, 20);

        Assertions.assertEquals(4, cityFuelCost);
    }

    @Test
    public void simulateCityFuelAmount() {
        Vehicle vehicle = new Vehicle();
        vehicle.setConsumoMedioCidade(10);

        double cityFuelCost = vehicle.simulatecityFuelAmout(20);

        Assertions.assertEquals(2, cityFuelCost);
    }

    @Test
    public void simulateHighwayFuelCost() {
        Vehicle vehicle = new Vehicle();
        vehicle.setConsumoMedioRodovia(10);

        double fuelCost = vehicle.simulateHighwayFuelCost(2, 20);

        Assertions.assertEquals(4, fuelCost);
    }

    @Test
    public void simulateHighwayFuelAmout() {
        Vehicle vehicle = new Vehicle();
        vehicle.setConsumoMedioRodovia(10);

        double fuelAmount = vehicle.simulateHighwayFuelAmout(20);

        Assertions.assertEquals(2, fuelAmount);
    }

}
