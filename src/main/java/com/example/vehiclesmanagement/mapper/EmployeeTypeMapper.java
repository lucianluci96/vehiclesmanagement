package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.EmployeeTypeDto;
import com.example.vehiclesmanagement.entities.EmployeeType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeTypeMapper {

    EmployeeType mapToEntity(EmployeeTypeDto employeeTypeDto);

    EmployeeTypeDto mapToDto(EmployeeType employeeType);
}
