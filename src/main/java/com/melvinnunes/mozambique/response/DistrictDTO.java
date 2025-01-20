package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;

import java.util.List;

public record DistrictDTO(
        String code,
        String designation,
        List<AdministrativePostDTO> administrativePostDTOS
) {
    public static DistrictDTO build(CountryData data, List<AdministrativePostDTO> administrativePostDTOS) {
        return new DistrictDTO(
                data.getCode(),
                data.getDescription(),
                administrativePostDTOS
        );
    }
}
