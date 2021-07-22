/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.service;

import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.model.VehicleDTO;
import com.ficticiusclean.vehicleservice.model.converter.VehicleDtoToVehicleConverter;
import com.ficticiusclean.vehicleservice.model.converter.VehicleToVehicleDtoConverter;
import com.ficticiusclean.vehicleservice.model.exception.InvalidOperationException;
import com.ficticiusclean.vehicleservice.model.exception.VehicleNotFoundException;
import com.ficticiusclean.vehicleservice.repository.VehicleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    @Autowired
    private VehicleDtoToVehicleConverter dtoToVehicleConverter;
    
    @Autowired
    private VehicleToVehicleDtoConverter vehicleToVehicleDTOConverter;
    
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO){
        //não pode ter dois veículos com o mesmo nome
        if(!vehicleRepository.findByName(vehicleDTO.getName()).isEmpty())
            throw new InvalidOperationException("Já existe um veículo com o nome: " + vehicleDTO.getName());
        
        Vehicle vehicle = dtoToVehicleConverter.convert(vehicleDTO);
        Vehicle vehicleSaved = vehicleRepository.save(vehicle);
        return vehicleToVehicleDTOConverter.convert(vehicleSaved);
    }
    
    public List<VehicleDTO> getAllVehiclesDTO(){
        List<Vehicle> vehiclesInDB = vehicleRepository.findAll();
        
        List<VehicleDTO> vehicleDtoList = new ArrayList<>();
        for(Vehicle vehicle: vehiclesInDB){
            vehicleDtoList.add(vehicleToVehicleDTOConverter.convert(vehicle));
        }
        return vehicleDtoList;
    }
    
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
    
    public VehicleDTO updateVehicle(long id, VehicleDTO vehicleDTO){
        Optional vehicleOptional = vehicleRepository.findById(id);
        if(!vehicleOptional.isPresent())
            throw new VehicleNotFoundException("Veículo com id: " + id + " não encontrado");
        
        //não pode ter veículo com o mesmo nome
        if(!vehicleRepository.findByNameAndIdNot(vehicleDTO.getName(), id).isEmpty())
            throw new InvalidOperationException("Já existe um veículo com o nome: " + vehicleDTO.getName());
        
        Vehicle newVehicle = dtoToVehicleConverter.convert(vehicleDTO);
        newVehicle.setId(id);
        
        Vehicle vehicleUpdated = vehicleRepository.save(newVehicle);
        return vehicleToVehicleDTOConverter.convert(vehicleUpdated);        
    }
    
    public void deleteVehicle(long id){
        Optional vehicleOptional = vehicleRepository.findById(id);
        if(!vehicleOptional.isPresent())
            throw new VehicleNotFoundException("Veículo com id: " + id + " não encontrado");
        
        vehicleRepository.deleteById(id);
    }
    
    public VehicleDTO getVehicle(long id){
        Optional vehicleOptional = vehicleRepository.findById(id);
        if(!vehicleOptional.isPresent())
            throw new VehicleNotFoundException("Veículo com id: " + id + " não encontrado");
        
        Vehicle vehicle = (Vehicle) vehicleOptional.get();
        return vehicleToVehicleDTOConverter.convert(vehicle);
    }
    
}
