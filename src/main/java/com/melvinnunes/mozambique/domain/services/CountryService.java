package com.melvinnunes.mozambique.domain.services;

import com.melvinnunes.mozambique.domain.repositories.CountryDataRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryDataRepo countryDataRepo;

    public CountryService(CountryDataRepo countryDataRepo) {
        this.countryDataRepo = countryDataRepo;
    }
}
