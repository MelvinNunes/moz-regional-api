package com.melvinnunes.mozambique.interfaces.controllers;

import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Health", description = "Health Check Endpoint")
@RestController
@RequestMapping("/v1/health")
public class HealthController {
    public ResponseEntity<ApiResponse<Void>> index() {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
                "The API is health!",
                null
        ));
    }
}
