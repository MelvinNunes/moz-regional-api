package com.melvinnunes.mozambique.domain.repositories;

import com.melvinnunes.mozambique.domain.entities.CountryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDataRepo extends JpaRepository<CountryData, Long> {
}
