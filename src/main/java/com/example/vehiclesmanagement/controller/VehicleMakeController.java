package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.VehicleMakeDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.VehicleMakeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehiclemake")
@AllArgsConstructor
public class VehicleMakeController extends HandleValidationException {

    private final VehicleMakeService vehicleMakeService;

    @ApiOperation(value = "View a list with all available vehicle make")
    @GetMapping
    public ResponseEntity<List<VehicleMakeDto>> getVehiclesMake() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleMakeService.getVehiclesMakes());
    }

    @ApiOperation(value = "Get vehicle make by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleMakeDto> getVehicleMakeById(@Valid @PathVariable long id) {
        VehicleMakeDto getVehicleMakes = vehicleMakeService.getVehicleMakeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleMakeService.getVehicleMakeById(id));
    }

    @ApiOperation(value = "Create vehicle make")
    @PostMapping
    public ResponseEntity<VehicleMakeDto> addVehicleMake(@Valid @RequestBody VehicleMakeDto vehicleMake) {
        VehicleMakeDto saveVehicleMake = vehicleMakeService.addVehicleMake(vehicleMake);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVehicleMake);
    }

    @ApiOperation(value = "Update vehicle make")
    @PutMapping
    public ResponseEntity<VehicleMakeDto> updateVehicleMake(@RequestBody VehicleMakeDto vehicleMake) {
        VehicleMakeDto updateVehicleMake = vehicleMakeService.updateVehicleMake(vehicleMake);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicleMake);
    }

    @ApiOperation(value = "Delete vehicle make by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleMake(@PathVariable long id) {
        vehicleMakeService.deleteVehicleMake(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("VehicleMake with ID " + id + " was removed.");
    }

}
