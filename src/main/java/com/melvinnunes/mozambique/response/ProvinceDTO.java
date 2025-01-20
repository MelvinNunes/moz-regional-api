package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;

public record ProvinceDTO(
        String code,
        String designation
) {
    public static ProvinceDTO build(CountryData data) {
        return new ProvinceDTO(
                data.getCode(),
                data.getDescription()
        );
    }
}
