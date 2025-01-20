package com.melvinnunes.mozambique.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "country_data")
@Entity
public class CountryData {
    @Id
    private Integer id;
    private String oldIdentification;
    private String code;
    private String description;
    private String parent;
    private String type;
}
