package com.melvinnunes.mozambique.response;

import com.melvinnunes.mozambique.domain.entities.CountryData;
import com.melvinnunes.mozambique.infrastructure.util.StringFormatter;

import java.util.List;

public record DistrictDTO(
        String code,
        String designation,
        List<DefaultItemDTO> defaultItemDTOS
) {
    public static DistrictDTO build(CountryData data, List<DefaultItemDTO> defaultItemDTOS) {
        return new DistrictDTO(
                data.getCode(),
                StringFormatter.capitalizeFirstLetters(data.getDescription()),
                defaultItemDTOS
        );
    }
}
