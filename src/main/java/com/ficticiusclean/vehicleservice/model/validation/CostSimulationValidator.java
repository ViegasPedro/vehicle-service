/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ficticiusclean.vehicleservice.model.validation;

import com.ficticiusclean.vehicleservice.model.CostSimulationDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created 21/07/2021
 *
 * @author Pedro Viegas <pedro_viegas@live.com>
 */
public class CostSimulationValidator implements ConstraintValidator<CostSimulation, CostSimulationDTO>{

    @Override
    public boolean isValid(CostSimulationDTO costSimulationDTO, ConstraintValidatorContext context) {
        //ambos valores não podem ser 0
        return !(costSimulationDTO.getTotalDistanceInCity() == 0
                && costSimulationDTO.getTotalDistanceInHighway() == 0);
    }

}
