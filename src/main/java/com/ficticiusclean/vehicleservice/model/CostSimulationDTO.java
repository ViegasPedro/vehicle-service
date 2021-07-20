/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

/**
 *
 * @author pedro
 */
public class CostSimulationDTO {
    
    private double precoGasolina;
    private double totalKmCidade;
    private double totalKmRodovia;

    public double getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public double getTotalKmCidade() {
        return totalKmCidade;
    }

    public void setTotalKmCidade(double totalKmCidade) {
        this.totalKmCidade = totalKmCidade;
    }

    public double getTotalKmRodovia() {
        return totalKmRodovia;
    }

    public void setTotalKmRodovia(double totalKmRodovia) {
        this.totalKmRodovia = totalKmRodovia;
    }
    
    
}
