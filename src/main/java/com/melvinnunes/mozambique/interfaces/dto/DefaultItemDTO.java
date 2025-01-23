package com.melvinnunes.mozambique.interfaces.dto;

import com.melvinnunes.mozambique.domain.entity.CountryData;
import com.melvinnunes.mozambique.infrastructure.util.StringFormatter;

public record DefaultItemDTO(
        String code,
        String designation
) {
    public static DefaultItemDTO build(CountryData data) {
        return new DefaultItemDTO(
                data.getCode(),
                StringFormatter.capitalizeFirstLetters(data.getDescription())
        );
    }
}
