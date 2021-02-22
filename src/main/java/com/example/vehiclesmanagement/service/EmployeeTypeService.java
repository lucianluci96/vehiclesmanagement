package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.EmployeeTypeDto;
import com.example.vehiclesmanagement.entities.EmployeeType;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.EmployeeTypeMapper;
import com.example.vehiclesmanagement.repository.EmployeeTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;
    private final EmployeeTypeMapper employeeTypeMapper;

    public List<EmployeeTypeDto> getEmployeeTypes() {
        return employeeTypeRepository.findAll()
                .stream()
                .map(employeeTypeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public EmployeeTypeDto getEmployeeTypeById(long id) {
        return employeeTypeMapper.mapToDto(getEmployeeType(id));
    }

    public EmployeeTypeDto addEmployeeType(EmployeeTypeDto employeeType) {
        descriptionIsNotCompleted(employeeType);
        EmployeeType saveEmployeeType = employeeTypeRepository.save(employeeTypeMapper.mapToEntity(employeeType));
        return employeeTypeMapper.mapToDto(saveEmployeeType);
    }

    public EmployeeTypeDto updateEmployeeType(EmployeeTypeDto employeeType) {
        descriptionIsNotCompleted(employeeType);
        getEmployeeType(employeeType.getId());

        EmployeeType updateEmployeeType = employeeTypeRepository.save(employeeTypeMapper.mapToEntity(employeeType));
        return employeeTypeMapper.mapToDto(updateEmployeeType);
    }

    public void deleteEmployeeType(long id) {
        getEmployeeType(id);
        employeeTypeRepository.deleteById(id);

    }

    private EmployeeType getEmployeeType(long id) {
        return employeeTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("EmployeeType with ID " + id + " not found"));
    }

    private void descriptionIsNotCompleted(EmployeeTypeDto employeeType) {
        if (employeeType.getDescription() == null) {
            employeeType.setDescription(employeeType.getName());
        }
    }
}
