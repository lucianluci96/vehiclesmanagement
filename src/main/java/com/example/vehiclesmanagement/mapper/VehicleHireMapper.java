package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.VehicleHireDto;
import com.example.vehiclesmanagement.entities.VehicleHire;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleHireMapper {

    VehicleHire mapToEntity(VehicleHireDto vehicleHireDto);

    VehicleHireDto mapToDto(VehicleHire vehicleHire);
}
