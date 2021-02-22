package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.VehicleHireDto;
import com.example.vehiclesmanagement.entities.VehicleHire;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.VehicleHireMapper;
import com.example.vehiclesmanagement.repository.ClientRepository;
import com.example.vehiclesmanagement.repository.LocationRepository;
import com.example.vehiclesmanagement.repository.VehicleHireRepository;
import com.example.vehiclesmanagement.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleHireService {

    private final VehicleHireRepository vehicleHireRepository;
    private final VehicleRepository vehicleRepository;
    private final ClientRepository clientRepository;
    private final LocationRepository locationRepository;
    private final VehicleHireMapper vehicleHireMapper;

    public List<VehicleHireDto> getVehicleHires() {
        return vehicleHireRepository.findAll()
                .stream()
                .map(vehicleHireMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public VehicleHireDto getVehicleHireById(long id) {
        return vehicleHireMapper.mapToDto(getVehicleHire(id));
    }

    public VehicleHireDto addVehicleHire(VehicleHireDto vehicleHire) {
        checkIfClientExists(vehicleHire.getClient_id());
        checkIfLocationExists(vehicleHire.getLocation_id());
        checkIfVehicleExists(vehicleHire.getVehicle_id());

        VehicleHire saveVehicleHire = vehicleHireRepository.save(vehicleHireMapper.mapToEntity(vehicleHire));
        return vehicleHireMapper.mapToDto(saveVehicleHire);
    }

    public VehicleHireDto updateVehicleHire(VehicleHireDto vehicleHire) {
        checkIfClientExists(vehicleHire.getClient_id());
        checkIfLocationExists(vehicleHire.getLocation_id());
        checkIfVehicleExists(vehicleHire.getVehicle_id());

        getVehicleHire(vehicleHire.getId());

        VehicleHire updateVehicleHire = vehicleHireRepository.save(vehicleHireMapper.mapToEntity(vehicleHire));

        return vehicleHireMapper.mapToDto(updateVehicleHire);
    }

    public void deleteVehicleHire(long id) {
        getVehicleHire(id);
        vehicleHireRepository.deleteById(id);

    }

    private VehicleHire getVehicleHire(long id) {
        return vehicleHireRepository.findById(id).orElseThrow(() -> new NotFoundException("VehicleHire with ID " + id + " was not found."));
    }

    private void checkIfLocationExists(Long countryId) {
        locationRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Location with ID " + countryId + " was not found."));
    }

    private void checkIfVehicleExists(Long cityId) {
        vehicleRepository.findById(cityId).orElseThrow(() -> new NotFoundException("Vehicle with ID " + cityId + " was not found."));
    }

    private void checkIfClientExists(Long cityId) {
        clientRepository.findById(cityId).orElseThrow(() -> new NotFoundException("Client with ID " + cityId + " was not found."));
    }

}
