package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.VehicleDto;
import com.example.vehiclesmanagement.entities.Vehicle;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.VehicleMapper;
import com.example.vehiclesmanagement.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final VehicleTypeRepository vehicleTypeRepository;
    private final VehicleMakeRepository vehicleMakeRepository;
    private final VehicleModelRepository vehicleModelRepository;
    private final VehicleStatusRepository vehicleStatusRepository;
    private final LocationRepository locationRepository;
    private final EmployeeRepository employeeRepository;

    public List<VehicleDto> getVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public VehicleDto getVehicleById(long id) {
        return vehicleMapper.mapToDto(getVehicle(id));
    }

    public VehicleDto addVehicle(VehicleDto vehicle) {
        checkIfEmployeeExists(vehicle.getEmployee_id());
        checkIfLocationExists(vehicle.getLocation_id());
        checkIfVehicleMakeExists(vehicle.getVehicle_make_id());
        checkIfVehicleModelExists(vehicle.getVehicle_model_id());
        checkIfVehicleStatusExists(vehicle.getVehicle_status_id());
        checkIfVehicleTypeExists(vehicle.getVehicle_status_id());

        Vehicle saveVehicle = vehicleRepository.save(vehicleMapper.mapToEntity(vehicle));
        return vehicleMapper.mapToDto(saveVehicle);
    }

    public VehicleDto updateVehicle(VehicleDto vehicle) {
        checkIfEmployeeExists(vehicle.getEmployee_id());
        checkIfLocationExists(vehicle.getLocation_id());
        checkIfVehicleMakeExists(vehicle.getVehicle_make_id());
        checkIfVehicleModelExists(vehicle.getVehicle_model_id());
        checkIfVehicleStatusExists(vehicle.getVehicle_status_id());
        checkIfVehicleTypeExists(vehicle.getVehicle_status_id());

        getVehicle(vehicle.getId());

        Vehicle updateVehicle = vehicleRepository.save(vehicleMapper.mapToEntity(vehicle));

        return vehicleMapper.mapToDto(updateVehicle);
    }

    public void deleteVehicle(long id) {
        getVehicle(id);
        vehicleRepository.deleteById(id);

    }

    private Vehicle getVehicle(long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException("Vehicle with ID " + id + " was not found."));
    }

    private void checkIfVehicleTypeExists(Long countryId) {
        vehicleTypeRepository.findById(countryId).orElseThrow(() -> new NotFoundException("VehicleType with ID " + countryId + " was not found."));
    }

    private void checkIfVehicleMakeExists(Long countryId) {
        vehicleMakeRepository.findById(countryId).orElseThrow(() -> new NotFoundException("VehicleMake with ID " + countryId + " was not found."));
    }

    private void checkIfVehicleModelExists(Long countryId) {
        vehicleModelRepository.findById(countryId).orElseThrow(() -> new NotFoundException("VehicleModel with ID " + countryId + " was not found."));
    }

    private void checkIfVehicleStatusExists(Long countryId) {
        vehicleStatusRepository.findById(countryId).orElseThrow(() -> new NotFoundException("VehicleType with ID " + countryId + " was not found."));
    }

    private void checkIfLocationExists(Long countryId) {
        locationRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Location with ID " + countryId + " was not found."));
    }

    private void checkIfEmployeeExists(Long countryId) {
        employeeRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Employee with ID " + countryId + " was not found."));
    }

}
