package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.VehicleMakeDto;
import com.example.vehiclesmanagement.entities.VehicleMake;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMakeMapper {

    VehicleMake mapToEntity(VehicleMakeDto vehicleMakeDto);

    VehicleMakeDto mapToDto(VehicleMake vehicleMake);
}

