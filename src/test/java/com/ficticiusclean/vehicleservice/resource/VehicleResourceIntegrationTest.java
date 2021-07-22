/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficticiusclean.vehicleservice.model.Vehicle;
import com.ficticiusclean.vehicleservice.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author pedro
 */
@WebMvcTest(VehicleResource.class)
public class VehicleResourceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService service;

    @Test
    public void saveShouldBe200() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("marca");
        vehicle.setModel("modelo");
        vehicle.setName("nome");
        vehicle.setAverageCityConsumption(10);
        vehicle.setAvaregeHighwayConsumption(10);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/vehicle")
                .content(asJsonString(vehicle))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
