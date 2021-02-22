package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.VehicleHireDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.VehicleHireService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehiclehires")
@AllArgsConstructor
public class VehicleHireController extends HandleValidationException {

    private final VehicleHireService vehicleHireService;

    @ApiOperation(value = "View a list with all vehicle hire")
    @GetMapping
    public ResponseEntity<List<VehicleHireDto>> getVehicleHires() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleHireService.getVehicleHires());
    }

    @ApiOperation(value = "Get vehicle hire by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleHireDto> getVehicleHireById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleHireService.getVehicleHireById(id));
    }

    @ApiOperation(value = "Create vehicle hire")
    @PostMapping
    public ResponseEntity<VehicleHireDto> addVehicleHire(@Valid @RequestBody VehicleHireDto vehicleHire) {
        VehicleHireDto saveVehicleHire = vehicleHireService.addVehicleHire(vehicleHire);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVehicleHire);
    }

    @ApiOperation(value = "Update vehicle hire")
    @PutMapping
    public ResponseEntity<VehicleHireDto> updateVehicleHire(@Valid @RequestBody VehicleHireDto vehicleHire) {
        VehicleHireDto updateVehicleHire = vehicleHireService.updateVehicleHire(vehicleHire);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicleHire);
    }

    @ApiOperation(value = "Delete vehicle hire by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleHire(@PathVariable long id) {
        vehicleHireService.deleteVehicleHire(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Vehicle Hire with ID " + id + " was removed.");
    }

}
