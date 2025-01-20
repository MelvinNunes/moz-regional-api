package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;

public record DefaultItemDTO(
        String code,
        String designation
) {
    public static DefaultItemDTO build(CountryData data) {
        return new DefaultItemDTO(
                data.getCode(),
                data.getDescription()
        );
    }
}
