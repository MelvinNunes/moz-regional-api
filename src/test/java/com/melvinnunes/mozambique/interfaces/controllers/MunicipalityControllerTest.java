package com.melvinnunes.mozambique.interfaces.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import com.melvinnunes.mozambique.interfaces.dto.MunicipalityDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class MunicipalityControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Integration - Get municipality details by code")
    void testGetMunicipalityDetails() throws Exception {
        String municipalityCode = "11";
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get(String.format("/v1/municipalities/%s", municipalityCode))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        String response = result.getResponse().getContentAsString();
        ApiResponse<MunicipalityDTO> apiResponse = objectMapper.readValue(response, new TypeReference<>() {});

    }

    @Test
    @DisplayName("Integration - Try to get a municipality that doesnt exist")
    void testGetMunicipalityDetailsNotFound() throws Exception {
        String municipalityCode = "municipality";
        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format("/v1/municipalities/%s", municipalityCode))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }
}