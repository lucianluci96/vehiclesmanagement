package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.VehicleMaintenanceDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.VehicleMaintenanceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehiclemaintenaces")
@AllArgsConstructor
public class VehicleMaintenanceController extends HandleValidationException {

    private final VehicleMaintenanceService vehicleMaintenanceService;

    @ApiOperation(value = "View a list with all vehicle maintenance")
    @GetMapping
    public ResponseEntity<List<VehicleMaintenanceDto>> getVehicleMaintenanceList() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleMaintenanceService.getVehicleMaintenanceList());
    }

    @ApiOperation(value = "Get vehicle maintenance by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleMaintenanceDto> getVehicleMaintenanceById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleMaintenanceService.getVehicleMaintenanceById(id));
    }

    @ApiOperation(value = "Create vehicle maintenance")
    @PostMapping
    public ResponseEntity<VehicleMaintenanceDto> addVehicleMaintenance(@Valid @RequestBody VehicleMaintenanceDto vehicleMaintenance) {
        VehicleMaintenanceDto saveVehicleMaintenance = vehicleMaintenanceService.addVehicleMaintenance(vehicleMaintenance);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVehicleMaintenance);
    }

    @ApiOperation(value = "Update vehicle maintenance")
    @PutMapping
    public ResponseEntity<VehicleMaintenanceDto> updateVehicleMaintenance(@Valid @RequestBody VehicleMaintenanceDto vehicleMaintenance) {
        VehicleMaintenanceDto updateVehicleMaintenance = vehicleMaintenanceService.updateVehicleMaintenance(vehicleMaintenance);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicleMaintenance);
    }

    @ApiOperation(value = "Delete vehicle maintenance by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleMaintenance(@PathVariable long id) {
        vehicleMaintenanceService.deleteVehicleMaintenance(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Vehicle Maintenance with ID " + id + " was removed.");
    }

}
