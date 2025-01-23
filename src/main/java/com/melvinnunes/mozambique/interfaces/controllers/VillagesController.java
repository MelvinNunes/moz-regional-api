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

@Tag(name = "Villages", description = "Villages collections")
@RestController
@RequestMapping("/v1/villages")
public class VillagesController {
    private final CountryService countryService;

    public VillagesController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(description = "List of villages of neighborhood")
    @GetMapping
    public ResponseEntity<ApiResponse<List<DefaultItemDTO>>> list(
            @Parameter(
                    description = "The unique code of the neighborhood. You can get in GET /v1/neighborhoods?localityCode={code} API",
                    required = true
            )
            @RequestParam(name = "neighborhoodCode") String code
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "List of villages",
                countryService.listVillages(code)
        ));
    }
}
