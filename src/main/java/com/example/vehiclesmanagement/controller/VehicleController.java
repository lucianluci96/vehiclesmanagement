package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.VehicleDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@AllArgsConstructor
public class VehicleController extends HandleValidationException {

    private final VehicleService vehicleService;

    @ApiOperation(value = "View a list with all vehicles")
    @GetMapping
    public ResponseEntity<List<VehicleDto>> getVehicles() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicles());
    }

    @ApiOperation(value = "Get vehicle by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicleById(id));
    }

    @ApiOperation(value = "Create vehicle")
    @PostMapping
    public ResponseEntity<VehicleDto> addVehicle(@Valid @RequestBody VehicleDto vehicle) {

        VehicleDto saveVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVehicle);
    }

    @ApiOperation(value = "Update vehicle")
    @PutMapping
    public ResponseEntity<VehicleDto> updateVehicle(@Valid @RequestBody VehicleDto vehicle) {
        VehicleDto updateVehicle = vehicleService.updateVehicle(vehicle);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicle);
    }

    @ApiOperation(value = "Delete vehicle by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Vehicle with ID " + id + " was removed.");
    }

}
