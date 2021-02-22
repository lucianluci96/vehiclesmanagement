package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.InvoiceDto;
import com.example.vehiclesmanagement.entities.Invoice;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.InvoiceMapper;
import com.example.vehiclesmanagement.repository.ClientRepository;
import com.example.vehiclesmanagement.repository.InvoiceRepository;
import com.example.vehiclesmanagement.repository.InvoiceStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;
    private final InvoiceStatusRepository invoiceStatusRepository;
    private final InvoiceMapper invoiceMapper;

    public List<InvoiceDto> getInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public InvoiceDto getInvoiceById(long id) {
        return invoiceMapper.mapToDto(getInvoice(id));
    }

    public InvoiceDto addInvoice(InvoiceDto invoice) {
        checkIfClientExists(invoice.getClient_id());
        checkIfInvoiceStatusExists(invoice.getInvoice_status_id());

        Invoice saveInvoice = invoiceRepository.save(invoiceMapper.mapToEntity(invoice));
        return invoiceMapper.mapToDto(saveInvoice);
    }

    public InvoiceDto updateInvoice(InvoiceDto invoice) {
        checkIfClientExists(invoice.getClient_id());
        checkIfInvoiceStatusExists(invoice.getInvoice_status_id());
        getInvoice(invoice.getId());

        Invoice updateInvoice = invoiceRepository.save(invoiceMapper.mapToEntity(invoice));

        return invoiceMapper.mapToDto(updateInvoice);
    }

    public void deleteInvoice(long id) {
        getInvoice(id);
        invoiceRepository.deleteById(id);

    }

    private Invoice getInvoice(long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new NotFoundException("Invoice with ID " + id + " was not found."));
    }

    private void checkIfInvoiceStatusExists(Long countryId) {
        invoiceStatusRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Invoice Status with ID " + countryId + " was not found."));
    }

    private void checkIfClientExists(Long countryId) {
        clientRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Client with ID " + countryId + " was not found."));
    }

}
