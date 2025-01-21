package com.melvinnunes.mozambique.controllers.v1;

import com.melvinnunes.mozambique.domain.services.CountryService;
import com.melvinnunes.mozambique.response.ApiResponse;
import com.melvinnunes.mozambique.response.DefaultItemDTO;
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

@Tag(name = "Neighborhoods", description = "Neighborhoods collections")
@RestController
@RequestMapping("/v1/neighborhoods")
public class NeighborhoodController {
    private final CountryService countryService;

    public NeighborhoodController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(description = "List of neighborhoods of locality")
    @GetMapping
    public ResponseEntity<ApiResponse<List<DefaultItemDTO>>> list(
            @Parameter(
                    description = "The unique code of the locality. You can get in GET /v1/localities?administrativePostOrTownshipCode={code} API",
                    required = true
            )
            @RequestParam(name = "localityCode") String code
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "List of neighborhoods",
                countryService.listNeighborhoods(code)
        ));
    }
}
