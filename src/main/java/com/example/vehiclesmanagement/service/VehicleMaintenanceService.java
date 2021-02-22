package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.VehicleMaintenanceDto;
import com.example.vehiclesmanagement.entities.VehicleMaintenance;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.VehicleMaintenanceMapper;
import com.example.vehiclesmanagement.repository.SupplierRepository;
import com.example.vehiclesmanagement.repository.VehicleMaintenanceRepository;
import com.example.vehiclesmanagement.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleMaintenanceService {

    private final VehicleMaintenanceRepository vehicleMaintenanceRepository;
    private final VehicleMaintenanceMapper vehicleMaintenanceMapper;
    private final VehicleRepository vehicleRepository;
    private final SupplierRepository supplierRepository;

    public List<VehicleMaintenanceDto> getVehicleMaintenanceList() {
        return vehicleMaintenanceRepository.findAll()
                .stream()
                .map(vehicleMaintenanceMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public VehicleMaintenanceDto getVehicleMaintenanceById(long id) {
        return vehicleMaintenanceMapper.mapToDto(getVehicleMaintenance(id));
    }

    public VehicleMaintenanceDto addVehicleMaintenance(VehicleMaintenanceDto vehicleMaintenance) {
        checkIfSupplierExists(vehicleMaintenance.getSupplier_id());
        checkIfVehicleExists(vehicleMaintenance.getVehicle_id());

        VehicleMaintenance saveVehicleMaintenance = vehicleMaintenanceRepository.save(vehicleMaintenanceMapper.mapToEntity(vehicleMaintenance));
        return vehicleMaintenanceMapper.mapToDto(saveVehicleMaintenance);
    }

    public VehicleMaintenanceDto updateVehicleMaintenance(VehicleMaintenanceDto vehicleMaintenance) {
        checkIfSupplierExists(vehicleMaintenance.getSupplier_id());
        checkIfVehicleExists(vehicleMaintenance.getVehicle_id());

        getVehicleMaintenance(vehicleMaintenance.getId());

        VehicleMaintenance updateVehicleMaintenance = vehicleMaintenanceRepository.save(vehicleMaintenanceMapper.mapToEntity(vehicleMaintenance));

        return vehicleMaintenanceMapper.mapToDto(updateVehicleMaintenance);
    }

    public void deleteVehicleMaintenance(long id) {
        getVehicleMaintenance(id);
        vehicleMaintenanceRepository.deleteById(id);

    }

    private VehicleMaintenance getVehicleMaintenance(long id) {
        return vehicleMaintenanceRepository.findById(id).orElseThrow(() -> new NotFoundException("VehicleMaintenance with ID " + id + " was not found."));
    }

    private void checkIfVehicleExists(Long countryId) {
        vehicleRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Vehicle with ID " + countryId + " was not found."));
    }

    private void checkIfSupplierExists(Long cityId) {
        supplierRepository.findById(cityId).orElseThrow(() -> new NotFoundException("Supplier with ID " + cityId + " was not found."));
    }

}
