package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.SupplierDto;
import com.example.vehiclesmanagement.entities.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier mapToEntity(SupplierDto supplierDto);

    SupplierDto mapToDto(Supplier supplier);
}
