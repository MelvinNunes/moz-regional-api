package com.melvinnunes.mozambique.domain.entity;

import jakarta.persistence.*;


@Table(name = "country_data")
@Entity
public class CountryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String oldIdentification;
    private String code;
    private String description;
    private String parent;
    private String type;

    public CountryData() {}

    public CountryData(Long id, String oldIdentification, String code, String description, String parent, String type) {
        this.id = id;
        this.oldIdentification = oldIdentification;
        this.code = code;
        this.description = description;
        this.parent = parent;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldIdentification() {
        return oldIdentification;
    }

    public void setOldIdentification(String oldIdentification) {
        this.oldIdentification = oldIdentification;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
