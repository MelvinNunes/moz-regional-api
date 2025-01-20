package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;
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
