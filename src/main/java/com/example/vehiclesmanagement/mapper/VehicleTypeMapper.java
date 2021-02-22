package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.VehicleTypeDto;
import com.example.vehiclesmanagement.entities.VehicleType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleTypeMapper {

    VehicleType mapToEntity(VehicleTypeDto vehicleTypeDto);

    VehicleTypeDto mapToDto(VehicleType vehicleType);
}

