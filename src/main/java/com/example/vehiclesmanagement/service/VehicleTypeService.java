package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.VehicleTypeDto;
import com.example.vehiclesmanagement.entities.VehicleType;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.VehicleTypeMapper;
import com.example.vehiclesmanagement.repository.VehicleTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;
    private final VehicleTypeMapper vehicleTypeMapper;

    public List<VehicleTypeDto> getVehiclesTypes() {
        return vehicleTypeRepository.findAll()
                .stream()
                .map(vehicleTypeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public VehicleTypeDto getVehicleTypeById(long id) {
        VehicleType getVehicleType = getVehicleType(id);
        return vehicleTypeMapper.mapToDto(getVehicleType);
    }

    public VehicleTypeDto addVehicleType(VehicleTypeDto vehicleType) {
        descriptionIsNotCompleted(vehicleType);
        VehicleType saveVehicleType = vehicleTypeRepository.save(vehicleTypeMapper.mapToEntity(vehicleType));
        return vehicleTypeMapper.mapToDto(saveVehicleType);
    }

    public VehicleTypeDto updateVehicleType(VehicleTypeDto vehicleType) {
        descriptionIsNotCompleted(vehicleType);
        getVehicleType(vehicleType.getId());
        VehicleType updateVehicleType = vehicleTypeRepository.save(vehicleTypeMapper.mapToEntity(vehicleType));

        return vehicleTypeMapper.mapToDto(updateVehicleType);
    }

    public void deleteVehicleType(long id) {
        getVehicleType(id);
        vehicleTypeRepository.deleteById(id);

    }

    private VehicleType getVehicleType(long id) {
        return vehicleTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("VehicleType with ID " + id + " not found"));
    }

    private void descriptionIsNotCompleted(VehicleTypeDto vehicleType) {
        if (vehicleType.getDescription() == null) {
            vehicleType.setDescription(vehicleType.getName());
        }
    }
}
