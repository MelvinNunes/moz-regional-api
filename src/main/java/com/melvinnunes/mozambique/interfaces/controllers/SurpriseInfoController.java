package com.melvinnunes.mozambique.interfaces.controllers;

import com.melvinnunes.mozambique.application.service.SurpriseInfoService;
import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Surprise Info", description = "Surprise collections")
@RestController
@RequestMapping("/v1/surprise-infos")
public class SurpriseInfoController {
    private final SurpriseInfoService surpriseInfoService;

    public SurpriseInfoController(SurpriseInfoService service) {
        this.surpriseInfoService = service;
    }

    @GetMapping
    @Operation(description = "Finds a new surprise info for province using AI")
    public ResponseEntity<ApiResponse<String>> index(
            @RequestParam(name = "provinceName") String provinceName
    ) {
        String data = surpriseInfoService.requestSurpriseInfo(provinceName);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "Here you'll find a new surprise info about your province",
                data
        ));
    }
}
