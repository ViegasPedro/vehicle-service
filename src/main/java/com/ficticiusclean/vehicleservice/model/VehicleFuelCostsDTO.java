/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author pedro
 */
public class VehicleFuelCostsDTO implements Comparable<VehicleFuelCostsDTO> {

    @JsonProperty("nome")
    private String name;
    @JsonProperty("marca")
    private String brand;
    @JsonProperty("modelo")
    private String model;
    @JsonProperty("ano")
    private Integer manufactureYear;
    @JsonProperty("quantidadeCombustivelGasto")
    private double totalFuelConsumed;
    @JsonProperty("valorCombustivelGasto")
    private double totalFuelCost;

    public VehicleFuelCostsDTO() {
    }

    public VehicleFuelCostsDTO(String nome, String marca, String modelo, Integer ano, double quantidadeCombustivelGasto, double valorCombustivelGasto) {
        this.name = nome;
        this.brand = marca;
        this.model = modelo;
        this.manufactureYear = ano;
        this.totalFuelConsumed = quantidadeCombustivelGasto;
        this.totalFuelCost = valorCombustivelGasto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public double getTotalFuelConsumed() {
        return totalFuelConsumed;
    }

    public void setTotalFuelConsumed(double totalFuelConsumed) {
        this.totalFuelConsumed = totalFuelConsumed;
    }

    public double getTotalFuelCost() {
        return totalFuelCost;
    }

    public void setTotalFuelCost(double totalFuelCost) {
        this.totalFuelCost = totalFuelCost;
    }

    public int compareTo(VehicleFuelCostsDTO o) {
        if (this.totalFuelCost < o.getTotalFuelCost())
            return -1;
        if (this.totalFuelCost > o.getTotalFuelCost())
            return 1;
        return 0;
    }

}
