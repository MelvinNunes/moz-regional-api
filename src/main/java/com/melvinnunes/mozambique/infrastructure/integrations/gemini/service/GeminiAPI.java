package com.melvinnunes.mozambique.infrastructure.integrations.gemini.service;

import com.melvinnunes.mozambique.infrastructure.integrations.gemini.dto.GeminiRequest;
import com.melvinnunes.mozambique.infrastructure.integrations.gemini.dto.GeminiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GeminiAPI {
    private static final String BASE_URL = "https://generativelanguage.googleapis.com";
    private static final String BASE_ENDPOINT = "/v1beta/models/gemini-1.5-flash:generateContent";
    private final WebClient webClient;
    private final String apiKey;

    public GeminiAPI(WebClient.Builder webClient, @Value("${gemini.api.key}") String apiKey) {
        this.webClient = webClient.baseUrl(BASE_URL).build();
        this.apiKey = apiKey;
    }

    public Mono<GeminiResponse> getPromptResponse(String message) {
        GeminiRequest request = new GeminiRequest(message);

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(BASE_ENDPOINT)
                        .queryParam("key", apiKey)
                        .build())
                .body(Mono.just(request), GeminiRequest.class)
                .retrieve()
                .bodyToMono(GeminiResponse.class)
                .onErrorMap(this::handleApiError);
    }


    private Throwable handleApiError(Throwable error) {
        // Log the error and potentially transform it
        return new RuntimeException("Gemini API request failed", error);
    }

}
