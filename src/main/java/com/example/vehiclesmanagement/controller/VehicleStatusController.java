package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.VehicleStatusDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.VehicleStatusService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehiclestatus")
@AllArgsConstructor
public class VehicleStatusController extends HandleValidationException {

    private final VehicleStatusService vehicleStatusService;

    @ApiOperation(value = "View a list with all available vehicle status")
    @GetMapping
    public ResponseEntity<List<VehicleStatusDto>> getVehiclesStatus() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleStatusService.getVehiclesStatus());
    }

    @ApiOperation(value = "Get vehicle status by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleStatusDto> getVehicleStatusById(@PathVariable long id) {
        VehicleStatusDto getVehicleStatus = vehicleStatusService.getVehicleStatusById(id);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleStatusService.getVehicleStatusById(id));
    }

    @ApiOperation(value = "Create vehicle status")
    @PostMapping
    public ResponseEntity<VehicleStatusDto> addVehicleStatus(@Valid @RequestBody VehicleStatusDto vehicleStatus) {
        VehicleStatusDto saveVehicleStatus = vehicleStatusService.addVehicleStatus(vehicleStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVehicleStatus);
    }

    @ApiOperation(value = "Update vehicle status")
    @PutMapping
    public ResponseEntity<VehicleStatusDto> updateVehicleStatus(@Valid @RequestBody VehicleStatusDto vehicleStatus) {
        VehicleStatusDto updateVehicleStatus = vehicleStatusService.updateVehicleStatus(vehicleStatus);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicleStatus);
    }

    @ApiOperation(value = "Delete vehicle status by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleStatus(@PathVariable long id) {
        vehicleStatusService.deleteVehicleStatus(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("VehicleStatus with ID " + id + " was removed.");
    }

}
