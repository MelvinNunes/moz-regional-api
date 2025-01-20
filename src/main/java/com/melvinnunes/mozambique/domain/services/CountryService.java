package com.melvinnunes.mozambique.domain.services;

import com.melvinnunes.mozambique.domain.repositories.CountryDataRepo;
import com.melvinnunes.mozambique.infrastructure.enums.CountryDataTypes;
import com.melvinnunes.mozambique.infrastructure.exceptions.ContentNotFound;
import com.melvinnunes.mozambique.response.AdministrativePostDTO;
import com.melvinnunes.mozambique.response.DistrictDTO;
import com.melvinnunes.mozambique.response.DistrictOrMunicipalityDTO;
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
        return provinces.stream().map(province -> ProvinceDTO.build(province, null)).toList();
    }

    public ProvinceDTO getProvinceWithDistricts(String provinceCode) {
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

    public DistrictDTO getDistrictDetails(String districtCode) {
        var district = countryDataRepo.findByTypeAndCode(CountryDataTypes.CM_DISTRICT.name(), districtCode);
        if (district.isEmpty()) {
            throw new ContentNotFound("The district with code " + districtCode + " does not exist.");
        }
        var adminPosts = countryDataRepo.findAllByTypeAndParentOrderByDescriptionAsc(CountryDataTypes.CM_ADMINPOST.name(), districtCode)
                .stream().map(AdministrativePostDTO::build).toList();
        return DistrictDTO.build(district.get(), adminPosts);
    }

    public void listLocalitiesByParentCode(String parentCode) {

    }

    public void listNeighborhoods(String localityCode) {

    }

    public void listVillages(String neighborhoodCode) {

    }

    public void listMunicipalityTownships(String municipalityCode) {

    }
}
