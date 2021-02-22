package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.VehicleMaintenanceDto;
import com.example.vehiclesmanagement.entities.VehicleMaintenance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMaintenanceMapper {

    VehicleMaintenance mapToEntity(VehicleMaintenanceDto vehicleMaintenanceDto);

    VehicleMaintenanceDto mapToDto(VehicleMaintenance vehicleMaintenance);

}

