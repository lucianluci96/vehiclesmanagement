package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.CountryDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.CountryService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryController extends HandleValidationException {

    private final CountryService countryService;

    @ApiOperation(value = "View a list with all available countries")
    @GetMapping
    public ResponseEntity<List<CountryDto>> getCountries() {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getCountries());
    }

    @ApiOperation(value = "Get country by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountryById(@Valid @PathVariable long id) {
        CountryDto getCountry = countryService.getCountryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getCountryById(id));
    }

    @ApiOperation(value = "Create country")
    @PostMapping
    public ResponseEntity<CountryDto> addCountry(@Valid @RequestBody CountryDto country) {
        CountryDto saveCountry = countryService.addCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCountry);
    }

    @ApiOperation(value = "Update country")
    @PutMapping
    public ResponseEntity<CountryDto> updateCountry(@RequestBody CountryDto country) {
        CountryDto updateCountry = countryService.updateCountry(country);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateCountry);
    }

    @ApiOperation(value = "Delete country by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Country with ID " + id + " was removed.");
    }
}