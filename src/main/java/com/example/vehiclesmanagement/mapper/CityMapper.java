package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.CityDto;
import com.example.vehiclesmanagement.entities.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City mapToEntity(CityDto cityDto);

    CityDto mapToDto(City city);
}
