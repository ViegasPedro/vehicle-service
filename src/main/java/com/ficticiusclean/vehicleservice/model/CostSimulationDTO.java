/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

import com.ficticiusclean.vehicleservice.model.validation.CostSimulation;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author pedro
 */
@CostSimulation
public class CostSimulationDTO {

    @PositiveOrZero(message = "O campo \"precoGasolina\" deve ser maior ou igual a 0")
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
