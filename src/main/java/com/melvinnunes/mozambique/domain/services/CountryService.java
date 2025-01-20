package com.melvinnunes.mozambique.domain.services;

import com.melvinnunes.mozambique.domain.repositories.CountryDataRepo;
import com.melvinnunes.mozambique.infrastructure.enums.CountryDataTypes;
import com.melvinnunes.mozambique.infrastructure.exceptions.ContentNotFound;
import com.melvinnunes.mozambique.response.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryDataRepo countryDataRepo;

    public CountryService(CountryDataRepo countryDataRepo) {
        this.countryDataRepo = countryDataRepo;
    }


    @Cacheable(value = "provinces")
    public List<ProvinceDTO> listProvinces() {
        var provinces = countryDataRepo.findAllByTypeOrderByCodeAsUnsignedDesc(CountryDataTypes.CM_PROVINCE.name());
        return provinces.stream().map(province -> ProvinceDTO.build(province, null)).toList();
    }

    @Cacheable(value = "provinceDetails", key = "#provinceCode")
    public ProvinceDTO getProvinceDetails(String provinceCode) {
        var province = countryDataRepo.findByTypeAndCode(CountryDataTypes.CM_PROVINCE.name(), provinceCode);
        if (province.isEmpty()) {
            throw new ContentNotFound("The province with code " + provinceCode + " does not exist.");
        }
        var districtsAndMunicipalities = countryDataRepo.findAllByTypeInAndParentOrderByDescriptionAsc(new String[]{
                CountryDataTypes.CM_DISTRICT.name(),
                CountryDataTypes.CM_MUNICIPALITY.name()
        }, provinceCode).stream().map(DistrictOrMunicipalityDTO::build).toList();

        var actualProvince = province.get();
        return ProvinceDTO.build(actualProvince, districtsAndMunicipalities);
    }

    @Cacheable(value = "districtDetails", key = "#districtCode")
    public DistrictDTO getDistrictDetails(String districtCode) {
        var district = countryDataRepo.findByTypeAndCode(CountryDataTypes.CM_DISTRICT.name(), districtCode);
        if (district.isEmpty()) {
            throw new ContentNotFound("The district with code " + districtCode + " does not exist.");
        }
        var adminPosts = countryDataRepo.findAllByTypeAndParentOrderByDescriptionAsc(CountryDataTypes.CM_ADMINPOST.name(), districtCode)
                .stream().map(DefaultItemDTO::build).toList();
        return DistrictDTO.build(district.get(), adminPosts);
    }

    @Cacheable(value = "municipalityDetails", key = "#municipalityCode")
    public MunicipalityDTO getMunicipalityDetails(String municipalityCode) {
        var municipality = countryDataRepo.findByTypeAndCode(CountryDataTypes.CM_MUNICIPALITY.name(), municipalityCode);
        if (municipality.isEmpty()) {
            throw new ContentNotFound("The municipality with code " + municipalityCode + " does not exist.");
        }
        var townships = countryDataRepo.findAllByTypeAndParentOrderByDescriptionAsc(CountryDataTypes.CM_TOWNSHIP.name(), municipalityCode)
                .stream().map(DefaultItemDTO::build).toList();
        return MunicipalityDTO.build(municipality.get(), townships);
    }

    @Cacheable(value = "localities", key = "#administrativePostOrTownshipCode")
    public List<DefaultItemDTO> listLocalitiesByParentCode(String administrativePostOrTownshipCode) {
        return countryDataRepo.findAllByTypeAndParentOrderByDescriptionAsc(CountryDataTypes.CM_LOCALITY.name(), administrativePostOrTownshipCode)
                .stream().map(DefaultItemDTO::build).toList();
    }

    public List<DefaultItemDTO> listNeighborhoods(String localityCode) {
        return countryDataRepo.findAllByTypeAndParentOrderByDescriptionAsc(CountryDataTypes.CM_NEIGHBORHOOD.name(), localityCode)
                .stream().map(DefaultItemDTO::build).toList();
    }

    public List<DefaultItemDTO> listVillages(String neighborhoodCode) {
        return countryDataRepo.findAllByTypeAndParentOrderByDescriptionAsc(CountryDataTypes.CM_VILLAGE.name(), neighborhoodCode)
                .stream().map(DefaultItemDTO::build).toList();
    }


}
