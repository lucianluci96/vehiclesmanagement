package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.VehicleStatusDto;
import com.example.vehiclesmanagement.entities.VehicleStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleStatusMapper {

    VehicleStatus mapToEntity(VehicleStatusDto vehicleStatusDto);

    VehicleStatusDto mapToDto(VehicleStatus vehicleStatus);
}

