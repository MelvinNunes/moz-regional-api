package com.melvinnunes.mozambique.interfaces.dto;

import com.melvinnunes.mozambique.domain.entity.CountryData;
import com.melvinnunes.mozambique.infrastructure.util.StringFormatter;

public record DistrictOrMunicipalityDTO(
        String code,
        String designation,
        String type
) {
    public static DistrictOrMunicipalityDTO build(CountryData data) {
        return new DistrictOrMunicipalityDTO(
                data.getCode(),
                StringFormatter.capitalizeFirstLetters(data.getDescription()),
                data.getType()
        );
    }
}
