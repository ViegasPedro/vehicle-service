/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.repository;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pedro
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    
    List<Vehicle> findByName(String name);
    
    List<Vehicle> findByNameAndIdNot(String name, long id);
    
}
