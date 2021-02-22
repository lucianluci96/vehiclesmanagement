package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.VehicleDto;
import com.example.vehiclesmanagement.entities.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    Vehicle mapToEntity(VehicleDto vehicleDto);

    VehicleDto mapToDto(Vehicle vehicle);
}
