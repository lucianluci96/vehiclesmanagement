package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.CountryDto;
import com.example.vehiclesmanagement.entities.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    Country mapToEntity(CountryDto countryDto);

    CountryDto mapToDto(Country country);
}
