package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.InvoiceStatusDto;
import com.example.vehiclesmanagement.entities.InvoiceStatus;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.InvoiceStatusMapper;
import com.example.vehiclesmanagement.repository.InvoiceStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceStatusService {

    private final InvoiceStatusRepository invoiceStatusRepository;
    private final InvoiceStatusMapper invoiceStatusMapper;

    public List<InvoiceStatusDto> getInvoiceStatus() {
        return invoiceStatusRepository.findAll()
                .stream()
                .map(invoiceStatusMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public InvoiceStatusDto getInvoiceStatusById(long id) {
        return invoiceStatusMapper.mapToDto(getInvoiceStatus(id));
    }

    public InvoiceStatusDto addInvoiceStatus(InvoiceStatusDto invoiceStatus) {
        descriptionIsNotCompleted(invoiceStatus);
        InvoiceStatus saveInvoiceStatus = invoiceStatusRepository.save(invoiceStatusMapper.mapToEntity(invoiceStatus));
        return invoiceStatusMapper.mapToDto(saveInvoiceStatus);
    }

    public InvoiceStatusDto updateInvoiceStatus(InvoiceStatusDto invoiceStatus) {
        descriptionIsNotCompleted(invoiceStatus);
        getInvoiceStatus(invoiceStatus.getId());

        InvoiceStatus updateInvoiceStatus = invoiceStatusRepository.save(invoiceStatusMapper.mapToEntity(invoiceStatus));
        return invoiceStatusMapper.mapToDto(updateInvoiceStatus);
    }

    public void deleteInvoiceStatus(long id) {
        getInvoiceStatus(id);
        invoiceStatusRepository.deleteById(id);

    }

    private InvoiceStatus getInvoiceStatus(long id) {
        return invoiceStatusRepository.findById(id).orElseThrow(() -> new NotFoundException("InvoiceStatus with ID " + id + " not found"));
    }

    private void descriptionIsNotCompleted(InvoiceStatusDto invoiceStatus) {
        if (invoiceStatus.getDescription() == null) {
            invoiceStatus.setDescription(invoiceStatus.getName());
        }
    }
}
