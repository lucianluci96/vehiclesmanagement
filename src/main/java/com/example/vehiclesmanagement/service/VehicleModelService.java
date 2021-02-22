package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.VehicleModelDto;
import com.example.vehiclesmanagement.entities.VehicleModel;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.VehicleModelMapper;
import com.example.vehiclesmanagement.repository.VehicleModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;
    private final VehicleModelMapper vehicleModelMapper;

    public List<VehicleModelDto> getVehicleModels() {
        return vehicleModelRepository.findAll()
                .stream()
                .map(vehicleModelMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public VehicleModelDto getVehicleModelById(long id) {
        return vehicleModelMapper.mapToDto(getVehicleModel(id));
    }

    public VehicleModelDto addVehicleModel(VehicleModelDto vehicleModel) {
        descriptionIsNotCompleted(vehicleModel);
        VehicleModel saveVehicleModel = vehicleModelRepository.save(vehicleModelMapper.mapToEntity(vehicleModel));
        return vehicleModelMapper.mapToDto(saveVehicleModel);
    }

    public VehicleModelDto updateVehicleModel(VehicleModelDto vehicleModel) {
        descriptionIsNotCompleted(vehicleModel);
        getVehicleModel(vehicleModel.getId());

        VehicleModel updateVehicleModel = vehicleModelRepository.save(vehicleModelMapper.mapToEntity(vehicleModel));
        return vehicleModelMapper.mapToDto(updateVehicleModel);
    }

    public void deleteVehicleModel(long id) {
        getVehicleModel(id);
        vehicleModelRepository.deleteById(id);

    }

    private VehicleModel getVehicleModel(long id) {
        return vehicleModelRepository.findById(id).orElseThrow(() -> new NotFoundException("VehicleModel with ID " + id + " not found"));
    }

    private void descriptionIsNotCompleted(VehicleModelDto vehicleModel) {
        if (vehicleModel.getDescription() == null) {
            vehicleModel.setDescription(vehicleModel.getName());
        }
    }
}
