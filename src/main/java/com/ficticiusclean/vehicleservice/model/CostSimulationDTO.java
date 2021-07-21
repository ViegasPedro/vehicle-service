/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import javax.validation.constraints.Positive;

/**
 *
 * @author pedro
 */
public class CostSimulationDTO {

    @Positive(message = "O campo \"precoGasolina\" deve ser maior que 0")
    private double precoGasolina;
    @Positive(message = "O campo \"totalKmCidade\" deve ser maior que 0")
    private double totalKmCidade;
    @Positive(message = "O campo \"totalKmRodovia\" deve ser maior que 0")
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
