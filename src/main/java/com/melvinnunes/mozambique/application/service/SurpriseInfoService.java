package com.melvinnunes.mozambique.application.service;

import com.melvinnunes.mozambique.infrastructure.exceptions.BadRequestException;
import com.melvinnunes.mozambique.infrastructure.integrations.gemini.dto.GeminiResponse;
import com.melvinnunes.mozambique.infrastructure.integrations.gemini.service.GeminiAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SurpriseInfoService {
    private static final String DEFAULT_MESSAGE = "Uma cena que todos sabemos é que Moz é maningue nice";
    private final GeminiAPI geminiAPI;
    private final Logger logger = LoggerFactory.getLogger(SurpriseInfoService.class);

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
        try {
            GeminiResponse response = geminiAPI.getPromptResponse(String.format("Um informação interessante sobre %s em moçambique", provinceName)).block();
            assert response != null;
            return response.getCandidates().get(0).getContent().getParts().get(0).getText();
        } catch (Exception e) {
            logger.error("Error fetching with gemini integration: {}", e.getMessage());
            return DEFAULT_MESSAGE;
        }
    }

    private List<String> validProvinceName() {
        return Stream.of("Cidade de Maputo", "Maputo", "Gaza", "Inhambane",
                "Sofala", "Manica", "Tete", "Zambézia", "Nampula", "Cabo Delgado", "Niassa")
                .map(String::toLowerCase).toList();
    }
}
