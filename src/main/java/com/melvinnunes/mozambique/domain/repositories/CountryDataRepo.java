package com.melvinnunes.mozambique.domain.repositories;

import com.melvinnunes.mozambique.domain.entities.CountryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryDataRepo extends JpaRepository<CountryData, Long> {
    Optional<CountryData> findByTypeAndCode(String type, String code);
    @Query(value = "SELECT * FROM country_data WHERE type = :type ORDER BY CAST(code AS UNSIGNED) DESC", nativeQuery = true)
    List<CountryData> findAllByTypeOrderByCodeAsUnsignedDesc(@Param("type") String type);
    List<CountryData> findAllByTypeAndParentOrderByDescriptionAsc(String type, String parent);
    List<CountryData> findAllByTypeInAndParentOrderByDescriptionAsc(String[] types, String parent);
    boolean existsByTypeAndCodeAndParent(String type, String code, String parent);
}
