package com.melvinnunes.mozambique.interfaces.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import com.melvinnunes.mozambique.interfaces.dto.ProvinceDTO;
import org.junit.jupiter.api.Assertions;
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

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class ProvinceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Integration - Test listing all provinces")
    void testListProvinces() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/provinces")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        String response = result.getResponse().getContentAsString();
        ApiResponse<List<ProvinceDTO>> apiResponse = objectMapper.readValue(response, new TypeReference<>() {});

        Assertions.assertNotNull(apiResponse);
        Assertions.assertNotNull(apiResponse.data());
        Assertions.assertEquals(11, apiResponse.data().size());
        Assertions.assertEquals("Cidade De Maputo", apiResponse.data().get(0).designation());
    }

    @Test
    @DisplayName("Integration - Test getting province details - Exists")
    void testGetProvinceDetails() throws Exception {
        String provinceCode = "11";
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get(String.format("/v1/provinces/%s", provinceCode))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        String response = result.getResponse().getContentAsString();
        ApiResponse<ProvinceDTO> apiResponse = objectMapper.readValue(response, new TypeReference<>() {});

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertNotNull(apiResponse.data());
        Assertions.assertEquals("11", apiResponse.data().code());
    }

    @Test
    @DisplayName("Integration - Test getting province details - Does Not Exists")
    void testGetProvinceDetailsNotFound() throws Exception {
        String provinceCode = "11tt";
        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format("/v1/provinces/%s", provinceCode))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }
}