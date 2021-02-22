package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.VehicleMakeDto;
import com.example.vehiclesmanagement.entities.VehicleMake;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.VehicleMakeMapper;
import com.example.vehiclesmanagement.repository.VehicleMakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleMakeService {

    private final VehicleMakeRepository vehicleMakeRepository;
    private final VehicleMakeMapper vehicleMakeMapper;

    public List<VehicleMakeDto> getVehiclesMakes() {
        return vehicleMakeRepository.findAll()
                .stream()
                .map(vehicleMakeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public VehicleMakeDto getVehicleMakeById(long id) {
        VehicleMake getVehicleMake = vehicleMakeRepository.findById(id).orElseThrow(() -> new NotFoundException("VehicleMake with ID " + id + " not found."));
        return vehicleMakeMapper.mapToDto(getVehicleMake);
    }

    public VehicleMakeDto addVehicleMake(VehicleMakeDto vehicleMake) {
        descriptionIsNotCompleted(vehicleMake);
        VehicleMake saveVehicleMake = vehicleMakeRepository.save(vehicleMakeMapper.mapToEntity(vehicleMake));
        return vehicleMakeMapper.mapToDto(saveVehicleMake);
    }

    public VehicleMakeDto updateVehicleMake(VehicleMakeDto vehicleMake) {
        descriptionIsNotCompleted(vehicleMake);
        getVehicleMake(vehicleMake.getId());
        VehicleMake updateVehicleMake = vehicleMakeRepository.save(vehicleMakeMapper.mapToEntity(vehicleMake));

        return vehicleMakeMapper.mapToDto(updateVehicleMake);
    }

    public void deleteVehicleMake(long id) {
        getVehicleMake(id);
        vehicleMakeRepository.deleteById(id);
    }

    private VehicleMake getVehicleMake(long id) {
        return vehicleMakeRepository.findById(id).orElseThrow(() -> new NotFoundException("VehicleMake with ID " + id + " not found"));
    }

    private void descriptionIsNotCompleted(VehicleMakeDto vehicleMake) {
        if (vehicleMake.getDescription() == null) {
            vehicleMake.setDescription(vehicleMake.getName());
        }
    }
}
