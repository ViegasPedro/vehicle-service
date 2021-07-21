/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
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
    private String nome;
    private String marca;
    private String modelo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataFabricacao;
    @Positive(message = "O campo \"consumoMedioCidade\" deve ter valor positivo")
    private double consumoMedioCidade;
    @Positive(message = "O campo \"consumoMedioRodovia\" deve ter valor positivo")
    private double consumoMedioRodovia;
    
    public double simulateCityFuelCost(double fuelCost, double distance){
        return simulatecityFuelAmout(distance) * fuelCost;
    }
    
    public double simulateHighwayFuelCost(double fuelCost, double distance){
        return simulateHighwayFuelAmout(distance) * fuelCost;
    }
    
    public double simulateHighwayFuelAmout(double distance){
        return distance/consumoMedioRodovia;
    }
    
    public double simulatecityFuelAmout(double distance){
        return distance/consumoMedioCidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public double getConsumoMedioCidade() {
        return consumoMedioCidade;
    }

    public void setConsumoMedioCidade(double consumoMedioCidade) {
        this.consumoMedioCidade = consumoMedioCidade;
    }

    public double getConsumoMedioRodovia() {
        return consumoMedioRodovia;
    }

    public void setConsumoMedioRodovia(double consumoMedioRodovia) {
        this.consumoMedioRodovia = consumoMedioRodovia;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", modelo=" + modelo + ", dataFabricacao=" + dataFabricacao + ", consumoMedioCidade=" + consumoMedioCidade + ", consumoMedioRodovia=" + consumoMedioRodovia + '}';
    }
   
    
}
