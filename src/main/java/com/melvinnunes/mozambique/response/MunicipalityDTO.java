package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;

import java.util.List;

public record MunicipalityDTO(
        String code,
        String designation,
        List<DefaultItemDTO> townships
) {
    public static MunicipalityDTO build(CountryData data, List<DefaultItemDTO> townships) {
        return new MunicipalityDTO(
                data.getCode(),
                data.getDescription(),
                townships
        );
    }
}
