package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.EmployeeDto;
import com.example.vehiclesmanagement.entities.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee mapToEntity(EmployeeDto employeeDto);

    EmployeeDto mapToDto(Employee employee);
}
