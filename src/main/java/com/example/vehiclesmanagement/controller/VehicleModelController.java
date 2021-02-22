package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.VehicleModelDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.VehicleModelService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehiclemodels")
@AllArgsConstructor
public class VehicleModelController extends HandleValidationException {

    private final VehicleModelService vehicleModelService;

    @ApiOperation(value = "View a list with all available vehicle models")
    @GetMapping
    public ResponseEntity<List<VehicleModelDto>> getVehicleModels() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleModelService.getVehicleModels());
    }

    @ApiOperation(value = "Get vehicle model by ID")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleModelDto> getVehicleModelById(@PathVariable long id) {
        VehicleModelDto getVehicleModel = vehicleModelService.getVehicleModelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleModelService.getVehicleModelById(id));
    }

    @ApiOperation(value = "Create vehicle model")
    @PostMapping
    public ResponseEntity<VehicleModelDto> addVehicleModel(@Valid @RequestBody VehicleModelDto vehicleModel) {
        VehicleModelDto saveVehicleModel = vehicleModelService.addVehicleModel(vehicleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVehicleModel);
    }

    @ApiOperation(value = "Update vehicle model")
    @PutMapping
    public ResponseEntity<VehicleModelDto> updateVehicleModel(@Valid @RequestBody VehicleModelDto vehicleModel) {
        VehicleModelDto updateVehicleModel = vehicleModelService.updateVehicleModel(vehicleModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateVehicleModel);
    }

    @ApiOperation(value = "Delete vehicle model by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleModel(@PathVariable long id) {
        vehicleModelService.deleteVehicleModel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("VehicleModel with ID " + id + " was removed.");
    }

}
