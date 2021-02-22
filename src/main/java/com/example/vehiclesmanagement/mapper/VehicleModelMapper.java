package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.VehicleModelDto;
import com.example.vehiclesmanagement.entities.VehicleModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleModelMapper {

    VehicleModel mapToEntity(VehicleModelDto vehicleModelDto);

    VehicleModelDto mapToDto(VehicleModel vehicleModel);
}

