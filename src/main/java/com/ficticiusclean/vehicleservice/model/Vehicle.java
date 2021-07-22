/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Positive;

/**
 *
 * @author pedro
 */
@Entity
public class Vehicle implements Serializable {
    
    @GeneratedValue
    @javax.persistence.Id
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

    public double simulateCityFuelCost(double fuelCost, double distance){
        return simulatecityFuelAmout(distance) * fuelCost;
    }
    
    public double simulateHighwayFuelCost(double fuelCost, double distance){
        return simulateHighwayFuelAmout(distance) * fuelCost;
    }
    
    public double simulateHighwayFuelAmout(double distance){
        return distance/avaregeHighwayConsumption;
    }
    
    public double simulatecityFuelAmout(double distance){
        return distance/averageCityConsumption;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getMarca() {
        return brand;
    }

    public void setMarca(String marca) {
        this.brand = marca;
    }

    public String getModelo() {
        return model;
    }

    public void setModelo(String modelo) {
        this.model = modelo;
    }

    public LocalDate getDataFabricacao() {
        return manufactureDate;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.manufactureDate = dataFabricacao;
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
