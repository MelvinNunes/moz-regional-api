package com.melvinnunes.mozambique.controllers.v1;

import com.melvinnunes.mozambique.domain.services.CountryService;
import com.melvinnunes.mozambique.response.ApiResponse;
import com.melvinnunes.mozambique.response.DistrictDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Districts", description = "Districts collections")
@RestController
@RequestMapping("/v1/districts")
public class DistrictController {
    private final CountryService countryService;

    public DistrictController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(description = "Details of a district by code")
    @GetMapping("/{districtCode}")
    public ResponseEntity<ApiResponse<DistrictDTO>> details(@PathVariable(name = "districtCode") String districtCode) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "Details of the district",
                countryService.getDistrictDetails(districtCode)
        ));
    }
}
