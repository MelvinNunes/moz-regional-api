package com.melvinnunes.mozambique.interfaces.dto;

import com.melvinnunes.mozambique.domain.entity.CountryData;
import com.melvinnunes.mozambique.infrastructure.util.StringFormatter;

import java.util.List;

public record MunicipalityDTO(
        String code,
        String designation,
        List<DefaultItemDTO> townships
) {
    public static MunicipalityDTO build(CountryData data, List<DefaultItemDTO> townships) {
        return new MunicipalityDTO(
                data.getCode(),
                StringFormatter.capitalizeFirstLetters(data.getDescription()),
                townships
        );
    }
}
