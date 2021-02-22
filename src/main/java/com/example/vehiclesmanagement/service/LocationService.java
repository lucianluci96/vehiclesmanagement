package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.LocationDto;
import com.example.vehiclesmanagement.entities.Location;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.LocationMapper;
import com.example.vehiclesmanagement.repository.CityRepository;
import com.example.vehiclesmanagement.repository.CountryRepository;
import com.example.vehiclesmanagement.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final LocationMapper locationMapper;

    public List<LocationDto> getLocations() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public LocationDto getLocationById(long id) {
        return locationMapper.mapToDto(getLocation(id));
    }

    public LocationDto addLocation(LocationDto location) {
        checkIfCountryExists(location.getCountry_id());
        checkIfCityExists(location.getCity_id());

        Location saveLocation = locationRepository.save(locationMapper.mapToEntity(location));
        return locationMapper.mapToDto(saveLocation);
    }

    public LocationDto updateLocation(LocationDto location) {
        checkIfCountryExists(location.getCountry_id());
        checkIfCityExists(location.getCity_id());

        getLocation(location.getId());

        Location updateLocation = locationRepository.save(locationMapper.mapToEntity(location));

        return locationMapper.mapToDto(updateLocation);
    }

    public void deleteLocation(long id) {
        getLocation(id);
        locationRepository.deleteById(id);

    }

    private Location getLocation(long id) {
        return locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location with ID " + id + " was not found."));
    }

    private void checkIfCountryExists(Long countryId) {
        countryRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Country with ID " + countryId + " was not found."));
    }

    private void checkIfCityExists(Long cityId) {
        cityRepository.findById(cityId).orElseThrow(() -> new NotFoundException("City with ID " + cityId + " was not found."));
    }

}
