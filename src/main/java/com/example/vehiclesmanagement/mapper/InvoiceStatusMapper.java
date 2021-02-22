package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.InvoiceStatusDto;
import com.example.vehiclesmanagement.entities.InvoiceStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceStatusMapper {

    InvoiceStatus mapToEntity(InvoiceStatusDto invoiceStatusDto);

    InvoiceStatusDto mapToDto(InvoiceStatus invoiceStatus);
}

