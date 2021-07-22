/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import javax.validation.constraints.Positive;

/**
 *
 * @author pedro
 */
public class VehicleDTO {

    private long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("marca")
    private String brand;
    @JsonProperty("modelo")
    private String model;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty("dataFabricacao")
    private LocalDate manufactureDate;
    @Positive(message = "O campo \"consumoMedioCidade\" deve ter valor positivo")
    @JsonProperty("consumoMedioCidade")
    private double averageCityConsumption;
    @Positive(message = "O campo \"consumoMedioRodovia\" deve ter valor positivo")
    @JsonProperty("consumoMedioRodovia")
    private double avaregeHighwayConsumption;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public double getAverageCityConsumption() {
        return averageCityConsumption;
    }

    public void setAverageCityConsumption(double averageCityConsumption) {
        this.averageCityConsumption = averageCityConsumption;
    }

    public double getAvaregeHighwayConsumption() {
        return avaregeHighwayConsumption;
    }

    public void setAvaregeHighwayConsumption(double avaregeHighwayConsumption) {
        this.avaregeHighwayConsumption = avaregeHighwayConsumption;
    }
    
    
}
