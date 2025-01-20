package com.melvinnunes.mozambique.controllers.v1;

import com.melvinnunes.mozambique.domain.services.CountryService;
import com.melvinnunes.mozambique.response.ApiResponse;
import com.melvinnunes.mozambique.response.ProvinceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Provinces", description = "Provinces collections")
@RestController
@RequestMapping("/v1/provinces")
public class ProvinceController {
    private final CountryService countryService;

    public ProvinceController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(description = "List of provinces")
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProvinceDTO>>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "List of provinces",
                countryService.listProvinces()
        ));
    }


    @Operation(description = "Details of province using")
    @GetMapping("/{provinceCode}")
    public ResponseEntity<ApiResponse<ProvinceDTO>> details(@PathVariable(name = "provinceCode") String provinceCode) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "Details of the province",
                countryService.getProvinceDetails(provinceCode)
        ));
    }
}
