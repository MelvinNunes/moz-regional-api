package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;

public record DistrictOrMunicipalityDTO(
        String code,
        String designation,
        String type
) {
    public static DistrictOrMunicipalityDTO build(CountryData data) {
        return new DistrictOrMunicipalityDTO(
                data.getCode(),
                data.getDescription(),
                data.getType()
        );
    }
}
