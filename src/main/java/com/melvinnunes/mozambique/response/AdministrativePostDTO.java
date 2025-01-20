package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;

public record AdministrativePostDTO(
        String code,
        String designation
) {
    public static AdministrativePostDTO build(CountryData data) {
        return new AdministrativePostDTO(
                data.getCode(),
                data.getDescription()
        );
    }
}
