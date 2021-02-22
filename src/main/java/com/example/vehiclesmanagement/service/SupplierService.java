package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.SupplierDto;
import com.example.vehiclesmanagement.entities.Supplier;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.SupplierMapper;
import com.example.vehiclesmanagement.repository.CityRepository;
import com.example.vehiclesmanagement.repository.CountryRepository;
import com.example.vehiclesmanagement.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final SupplierMapper supplierMapper;

    public List<SupplierDto> getSuppliers() {
        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public SupplierDto getSupplierById(long id) {
        return supplierMapper.mapToDto(getSupplier(id));
    }

    public SupplierDto addSupplier(SupplierDto supplier) {
        checkIfCountryExists(supplier.getCountry_id());
        checkIfCityExists(supplier.getCity_id());

        Supplier saveSupplier = supplierRepository.save(supplierMapper.mapToEntity(supplier));
        return supplierMapper.mapToDto(saveSupplier);
    }

    public SupplierDto updateSupplier(SupplierDto supplier) {
        checkIfCountryExists(supplier.getCountry_id());
        checkIfCityExists(supplier.getCity_id());

        getSupplier(supplier.getId());

        Supplier updateSupplier = supplierRepository.save(supplierMapper.mapToEntity(supplier));

        return supplierMapper.mapToDto(updateSupplier);
    }

    public void deleteSupplier(long id) {
        getSupplier(id);
        supplierRepository.deleteById(id);

    }

    private Supplier getSupplier(long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new NotFoundException("Supplier with ID " + id + " was not found."));
    }

    private void checkIfCountryExists(Long countryId) {
        countryRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Country with ID " + countryId + " was not found."));
    }

    private void checkIfCityExists(Long cityId) {
        cityRepository.findById(cityId).orElseThrow(() -> new NotFoundException("City with ID " + cityId + " was not found."));
    }

}
