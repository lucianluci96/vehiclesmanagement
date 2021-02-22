package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.VehicleStatusDto;
import com.example.vehiclesmanagement.entities.VehicleStatus;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.VehicleStatusMapper;
import com.example.vehiclesmanagement.repository.VehicleStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleStatusService {

    private final VehicleStatusRepository vehicleStatusRepository;
    private final VehicleStatusMapper vehicleStatusMapper;

    public List<VehicleStatusDto> getVehiclesStatus() {
        return vehicleStatusRepository.findAll()
                .stream()
                .map(vehicleStatusMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public VehicleStatusDto getVehicleStatusById(long id) {
        return vehicleStatusMapper.mapToDto(getVehicleStatus(id));
    }

    public VehicleStatusDto addVehicleStatus(VehicleStatusDto vehicleStatus) {
        descriptionIsNotCompleted(vehicleStatus);
        VehicleStatus saveVehicleStatus = vehicleStatusRepository.save(vehicleStatusMapper.mapToEntity(vehicleStatus));
        return vehicleStatusMapper.mapToDto(saveVehicleStatus);
    }

    public VehicleStatusDto updateVehicleStatus(VehicleStatusDto vehicleStatus) {
        descriptionIsNotCompleted(vehicleStatus);
        getVehicleStatus(vehicleStatus.getId());

        VehicleStatus updateVehicleStatus = vehicleStatusRepository.save(vehicleStatusMapper.mapToEntity(vehicleStatus));
        return vehicleStatusMapper.mapToDto(updateVehicleStatus);
    }

    public void deleteVehicleStatus(long id) {
        getVehicleStatus(id);
        vehicleStatusRepository.deleteById(id);

    }

    private VehicleStatus getVehicleStatus(long id) {
        return vehicleStatusRepository.findById(id).orElseThrow(() -> new NotFoundException("VehicleStatus with ID " + id + " not found"));
    }

    private void descriptionIsNotCompleted(VehicleStatusDto vehicleStatus) {
        if (vehicleStatus.getDescription() == null) {
            vehicleStatus.setDescription(vehicleStatus.getName());
        }
    }
}
