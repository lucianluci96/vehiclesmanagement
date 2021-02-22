package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.LocationDto;
import com.example.vehiclesmanagement.entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location mapToEntity(LocationDto locationDto);

    LocationDto mapToDto(Location location);
}
