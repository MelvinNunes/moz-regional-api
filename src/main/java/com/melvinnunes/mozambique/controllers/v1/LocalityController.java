package com.melvinnunes.mozambique.controllers.v1;

import com.melvinnunes.mozambique.domain.services.CountryService;
import com.melvinnunes.mozambique.response.ApiResponse;
import com.melvinnunes.mozambique.response.DefaultItemDTO;
import com.melvinnunes.mozambique.response.ProvinceDTO;
import io.swagger.v3.oas.annotations.Operation;
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
            @RequestParam(name = "administrativePostOrTownshipCode") String code
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "List of localities",
                countryService.listLocalitiesByParentCode(code)
        ));
    }
}
