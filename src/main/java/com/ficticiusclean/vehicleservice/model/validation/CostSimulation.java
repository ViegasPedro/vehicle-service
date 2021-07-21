/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Created 21/07/2021
 *
 * @author Pedro Viegas <pedro_viegas@live.com>
 */

@Constraint(validatedBy = CostSimulationValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CostSimulation {
    String message() default "Os campos \"totalKmRodovia\" e \"totalKmCidade\" não podem ser 0, pelo menos um campo é obrigatório";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
