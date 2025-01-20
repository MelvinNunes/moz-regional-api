package com.melvinnunes.mozambique.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.melvinnunes.mozambique.domain.entities.CountryData;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProvinceDTO(
        String code,
        String designation,
        List<DistrictOrMunicipalityDTO> districtsAndMunicipalities
) {
    public static ProvinceDTO build(CountryData data, List<DistrictOrMunicipalityDTO> districtsAndMunicipalities) {
        return new ProvinceDTO(
                data.getCode(),
                data.getDescription(),
                districtsAndMunicipalities
        );
    }
}
