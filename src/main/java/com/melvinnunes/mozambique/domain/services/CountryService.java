package com.melvinnunes.mozambique.domain.services;

import com.melvinnunes.mozambique.domain.repositories.CountryDataRepo;
import com.melvinnunes.mozambique.infrastructure.enums.CountryDataTypes;
import com.melvinnunes.mozambique.response.ProvinceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryDataRepo countryDataRepo;

    public CountryService(CountryDataRepo countryDataRepo) {
        this.countryDataRepo = countryDataRepo;
    }

    public List<ProvinceDTO> listProvinces() {
        var provinces = countryDataRepo.findAllByTypeOrderByCodeAsUnsignedDesc(CountryDataTypes.CM_PROVINCE.name());
        return provinces.stream().map(ProvinceDTO::build).toList();
    }
}
