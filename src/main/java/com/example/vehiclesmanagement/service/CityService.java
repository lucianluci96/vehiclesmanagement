package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.CityDto;
import com.example.vehiclesmanagement.entities.City;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.CityMapper;
import com.example.vehiclesmanagement.repository.CityRepository;
import com.example.vehiclesmanagement.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final CityMapper cityMapper;

    public List<CityDto> getCities() {
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::mapToDto)
                .collect(Collectors.toList());
    }


    public List<CityDto> getCitiesFromCountry(Long countryId) {
        checkIfCountryExists(countryId);
        return cityRepository.getCitiesFromCountry(countryId)
                .stream()
                .map(cityMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CityDto getCityById(long id) {
        return cityMapper.mapToDto(getCity(id));
    }

    public CityDto addCity(CityDto city) {
        checkIfCountryExists(city.getCountry_id());

        City saveCity = cityRepository.save(cityMapper.mapToEntity(city));
        return cityMapper.mapToDto(saveCity);
    }

    public CityDto updateCity(CityDto city) {
        checkIfCountryExists(city.getCountry_id());
        getCity(city.getId());

        City updateCity = cityRepository.save(cityMapper.mapToEntity(city));

        return cityMapper.mapToDto(updateCity);
    }

    public void deleteCity(long id) {
        getCity(id);
        cityRepository.deleteById(id);

    }

    private City getCity(long id) {
        return cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City with ID " + id + " was not found."));
    }

    private void checkIfCountryExists(Long countryId) {
        countryRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Country with ID " + countryId + " was not found."));
    }

}
