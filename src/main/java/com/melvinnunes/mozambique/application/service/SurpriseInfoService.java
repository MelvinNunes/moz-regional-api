package com.melvinnunes.mozambique.application.service;

import com.melvinnunes.mozambique.infrastructure.exceptions.BadRequestException;
import com.melvinnunes.mozambique.infrastructure.integrations.gemini.dto.GeminiResponse;
import com.melvinnunes.mozambique.infrastructure.integrations.gemini.service.GeminiAPI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SurpriseInfoService {
    private final GeminiAPI geminiAPI;

    public SurpriseInfoService(GeminiAPI geminiAPI) {
        this.geminiAPI = geminiAPI;
    }

    public String requestSurpriseInfo(String provinceName) {
        if (!validProvinceName().contains(provinceName.toLowerCase())) {
            throw new BadRequestException("Invalid province name inserted!");
        }
        return resolveGeminiResponse(provinceName);
    }

    private String resolveGeminiResponse(String provinceName) {
        GeminiResponse response = geminiAPI.getPromptResponse("Um informação interessante sobre cidade de maputo em moçambique").block();
        assert response != null;
        return response.getCandidates().get(0).getContent().getParts().get(0).getText();
    }

    private List<String> validProvinceName() {
        return Stream.of("Cidade de Maputo", "Maputo", "Gaza", "Inhambane",
                "Sofala", "Manica", "Tete", "Zambézia", "Nampula", "Cabo Delgado", "Niassa")
                .map(String::toLowerCase).toList();
    }
}
