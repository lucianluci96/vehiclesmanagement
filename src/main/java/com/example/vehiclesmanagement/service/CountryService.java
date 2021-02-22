package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.CountryDto;
import com.example.vehiclesmanagement.entities.Country;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.CountryMapper;
import com.example.vehiclesmanagement.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryDto> getCountries() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CountryDto getCountryById(long id) {
        return countryMapper.mapToDto(getCountry(id));
    }


    public CountryDto addCountry(CountryDto country) {
        Country saveCountry = countryRepository.save(countryMapper.mapToEntity(country));
        return countryMapper.mapToDto(saveCountry);
    }

    public CountryDto updateCountry(CountryDto country) {
        getCountry(country.getId());
        Country updateCountry = countryRepository.save(countryMapper.mapToEntity(country));

        return countryMapper.mapToDto(updateCountry);
    }

    public void deleteCountry(long id) {
        getCountry(id);
        countryRepository.deleteById(id);

    }

    private Country getCountry(long id) {
        return countryRepository.findById(id).orElseThrow(() -> new NotFoundException("Country with ID " + id + " not found"));
    }


}
