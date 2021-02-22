package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private Long id;
    @NotNull(message = "Country Name is required")
    private String name;
    @NotNull(message = "Capital is required")
    private String capital;
    @NotNull(message = "Nationality is required")
    private String nationality;
    private String continent;
    private List<CityInCountryDto> cities;
}
