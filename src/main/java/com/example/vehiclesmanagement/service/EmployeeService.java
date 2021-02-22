package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.EmployeeDto;
import com.example.vehiclesmanagement.entities.Employee;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.EmployeeMapper;
import com.example.vehiclesmanagement.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final EmployeeTypeRepository employeeTypeRepository;
    private final JobTypeRepository jobTypeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(long id) {
        return employeeMapper.mapToDto(getEmployee(id));
    }

    public EmployeeDto addEmployee(EmployeeDto employee) {
        checkIfCountryExists(employee.getCountry_id());
        checkIfCityExists(employee.getCity_id());
        checkIfEmployeeTypeExists(employee.getEmployee_type_id());
        checkIfJobTypeExists(employee.getJob_type_id());

        Employee saveEmployee = employeeRepository.save(employeeMapper.mapToEntity(employee));
        return employeeMapper.mapToDto(saveEmployee);
    }

    public EmployeeDto updateEmployee(EmployeeDto employee) {
        checkIfCountryExists(employee.getCountry_id());
        checkIfCityExists(employee.getCity_id());
        checkIfEmployeeTypeExists(employee.getEmployee_type_id());
        checkIfJobTypeExists(employee.getJob_type_id());


        getEmployee(employee.getId());

        Employee updateEmployee = employeeRepository.save(employeeMapper.mapToEntity(employee));

        return employeeMapper.mapToDto(updateEmployee);
    }

    public void deleteEmployee(long id) {
        getEmployee(id);
        employeeRepository.deleteById(id);

    }

    private Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with ID " + id + " was not found."));
    }

    private void checkIfCountryExists(Long countryId) {
        countryRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Country with ID " + countryId + " was not found."));
    }

    private void checkIfEmployeeTypeExists(Long cityId) {
        employeeTypeRepository.findById(cityId).orElseThrow(() -> new NotFoundException("EmployeeType with ID " + cityId + " was not found."));
    }

    private void checkIfJobTypeExists(Long cityId) {
        jobTypeRepository.findById(cityId).orElseThrow(() -> new NotFoundException("JobType with ID " + cityId + " was not found."));
    }

    private void checkIfCityExists(Long cityId) {
        cityRepository.findById(cityId).orElseThrow(() -> new NotFoundException("City with ID " + cityId + " was not found."));
    }

}
