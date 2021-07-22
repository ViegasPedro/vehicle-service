/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.resource;

import com.ficticiusclean.vehicleservice.model.CostSimulationDTO;
import com.ficticiusclean.vehicleservice.model.VehicleFuelCostsDTO;
import com.ficticiusclean.vehicleservice.service.CostSimulationService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */
@RestController
@RequestMapping("/cost-simulation")
public class CostSimulationResource {
    
    @Autowired
    private CostSimulationService costSimulationService;
    
    @PostMapping
    public ResponseEntity<List<VehicleFuelCostsDTO>> simulateFuelCosts(@Valid @RequestBody CostSimulationDTO costSimulation){
        return ResponseEntity.ok(costSimulationService.simulateCosts(costSimulation));
    }
}
