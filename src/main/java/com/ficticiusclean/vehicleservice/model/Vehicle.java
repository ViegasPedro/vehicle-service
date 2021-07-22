/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 *
 * @author pedro
 */
@Entity
public class Vehicle implements Serializable {
    
    @GeneratedValue
    @javax.persistence.Id
    private long id;
    private String name;
    private String brand;
    private String model;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate manufactureDate;
    private double averageCityConsumption;
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

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", nome=" + name + ", marca=" + brand + ", modelo=" + model + ", dataFabricacao=" + manufactureDate + ", consumoMedioCidade=" + averageCityConsumption + ", consumoMedioRodovia=" + avaregeHighwayConsumption + '}';
    }
   
    
}
