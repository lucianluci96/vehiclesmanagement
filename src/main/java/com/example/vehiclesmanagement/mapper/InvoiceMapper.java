package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.InvoiceDto;
import com.example.vehiclesmanagement.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    Invoice mapToEntity(InvoiceDto invoiceDto);

    InvoiceDto mapToDto(Invoice invoice);
}
