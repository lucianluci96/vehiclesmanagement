package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.CityDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.CityService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CityController extends HandleValidationException {

    private final CityService cityService;

    @ApiOperation(value = "View a list with all available cities")
    @GetMapping
    public ResponseEntity<List<CityDto>> getCities() {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getCities());
    }

    @ApiOperation(value = "Get city by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getCityById(id));
    }

    @ApiOperation(value = "Create city")
    @PostMapping
    public ResponseEntity<CityDto> addCity(@Valid @RequestBody CityDto city) {
        CityDto saveCity = cityService.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCity);
    }

    @ApiOperation(value = "Update city")
    @PutMapping
    public ResponseEntity<CityDto> updateCity(@Valid @RequestBody CityDto city) {
        CityDto updateCity = cityService.updateCity(city);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateCity);
    }

    @ApiOperation(value = "Delete city by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable long id) {
        cityService.deleteCity(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("City with ID " + id + " was removed.");
    }

    @ApiOperation(value = "View a list with all available cities from a specific country")
    @GetMapping("/country={countryId}")
    public ResponseEntity<List<CityDto>> getCitiesFromCountry(@PathVariable Long countryId) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getCitiesFromCountry(countryId));
    }

}
