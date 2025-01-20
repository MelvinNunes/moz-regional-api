package com.melvinnunes.mozambique.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melvinnunes.mozambique.domain.services.CountryService;
import com.melvinnunes.mozambique.response.ProvinceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
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

    private CountryService countryService;

    @BeforeEach
    void setUp() {
        countryService = Mockito.mock(CountryService.class);
    }

    @Test
    void testListProvinces() throws Exception {
        // Arrange
        var provinces = List.of(
                new ProvinceDTO("001", "Province A", null),
                new ProvinceDTO("002", "Province B", null)
        );

        Mockito.when(countryService.listProvinces()).thenReturn(provinces);

        // Act
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/v1/provinces")
                .contentType(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("List of provinces"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].code").value("001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].description").value("Province A"));
    }
}