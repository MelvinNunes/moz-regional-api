package com.melvinnunes.mozambique.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.melvinnunes.mozambique.domain.entity.CountryData;
import com.melvinnunes.mozambique.infrastructure.util.StringFormatter;

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
                StringFormatter.capitalizeFirstLetters(data.getDescription()),
                districtsAndMunicipalities
        );
    }
}
