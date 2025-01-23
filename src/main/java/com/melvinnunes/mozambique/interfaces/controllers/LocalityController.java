package com.melvinnunes.mozambique.interfaces.controllers;

import com.melvinnunes.mozambique.application.service.CountryService;
import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import com.melvinnunes.mozambique.interfaces.dto.DefaultItemDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Localities", description = "Localities collections")
@RestController
@RequestMapping("/v1/localities")
public class LocalityController {
    private final CountryService countryService;

    public LocalityController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(description = "List of localities of given admin post or township")
    @GetMapping
    public ResponseEntity<ApiResponse<List<DefaultItemDTO>>> list(
            @Parameter(
                    description = "The unique code of the admin post or township. For admin post GET /v1/districts/{districtCode} and for township get in GET /v1/municipalities/{municipalityCode} API",
                    required = true
            )
            @RequestParam(name = "administrativePostOrTownshipCode") String code
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "List of localities",
                countryService.listLocalitiesByParentCode(code)
        ));
    }
}
