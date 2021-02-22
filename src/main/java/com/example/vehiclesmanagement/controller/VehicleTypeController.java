package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.VehicleTypeDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.VehicleTypeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehicletypes")
@AllArgsConstructor
public class VehicleTypeController extends HandleValidationException {

    private final VehicleTypeService vehicleTypeService;

    @ApiOperation(value = "View a list with all available vehicle types")
    @GetMapping
    public ResponseEntity<List<VehicleTypeDto>> getVehiclesTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.getVehiclesTypes());
    }

    @ApiOperation(value = "Get vehicle type by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleTypeDto> getVehicleTypeById(@PathVariable long id) {
        VehicleTypeDto getVehicleTypes = vehicleTypeService.getVehicleTypeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.getVehicleTypeById(id));
    }

    @ApiOperation(value = "Create vehicle type")
    @PostMapping
    public ResponseEntity<VehicleTypeDto> addVehicleType(@Valid @RequestBody VehicleTypeDto vehicleType) {
        VehicleTypeDto saveVehicleType = vehicleTypeService.addVehicleType(vehicleType);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVehicleType);
    }

    @ApiOperation(value = "Update vehicle type")
    @PutMapping
    public ResponseEntity<VehicleTypeDto> updateVehicleType(@Valid @RequestBody VehicleTypeDto vehicleType) {
        VehicleTypeDto updateVehicleType = vehicleTypeService.updateVehicleType(vehicleType);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicleType);
    }

    @ApiOperation(value = "Delete vehicle type by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleType(@PathVariable long id) {
        vehicleTypeService.deleteVehicleType(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("VehicleType with ID " + id + " was removed.");
    }

}
