package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.LocationDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.LocationService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
public class LocationController extends HandleValidationException {

    private final LocationService locationService;

    @ApiOperation(value = "View a list with all locations")
    @GetMapping
    public ResponseEntity<List<LocationDto>> getClients() {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocations());
    }

    @ApiOperation(value = "Get location by ID")
    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocationById(id));
    }

    @ApiOperation(value = "Create location")
    @PostMapping
    public ResponseEntity<LocationDto> addLocation(@Valid @RequestBody LocationDto location) {
        LocationDto saveLocation = locationService.addLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveLocation);
    }

    @ApiOperation(value = "Update location")
    @PutMapping
    public ResponseEntity<LocationDto> updateLocation(@Valid @RequestBody LocationDto location) {
        LocationDto updateLocation = locationService.updateLocation(location);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateLocation);
    }

    @ApiOperation(value = "Delete location by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Location with ID " + id + " was removed.");
    }

}
