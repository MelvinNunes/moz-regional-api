package com.melvinnunes.mozambique.interfaces.controllers;

import com.melvinnunes.mozambique.application.service.CountryService;
import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import com.melvinnunes.mozambique.interfaces.dto.MunicipalityDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Municipalities", description = "Municipalities collections")
@RestController
@RequestMapping("/v1/municipalities")
public class MunicipalityController {
    private final CountryService countryService;

    public MunicipalityController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(description = "Get municipality details")
    @GetMapping("/{municipalityCode}")
    public ResponseEntity<ApiResponse<MunicipalityDTO>> details(
            @Parameter(
                    description = "The unique code of the municipality. You can get in GET /v1/provinces/{provinceCode} API",
                    required = true
            )
            @PathVariable(name = "municipalityCode") String municipalityCode
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "Details of Municipality",
                countryService.getMunicipalityDetails(municipalityCode)
        ));
    }
}
