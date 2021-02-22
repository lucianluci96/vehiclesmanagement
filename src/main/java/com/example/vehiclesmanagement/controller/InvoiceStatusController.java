package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.InvoiceStatusDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.InvoiceStatusService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/invoicestatus")
@AllArgsConstructor
public class InvoiceStatusController extends HandleValidationException {

    private final InvoiceStatusService invoiceStatusService;

    @ApiOperation(value = "View a list with all available invoices status")
    @GetMapping
    public ResponseEntity<List<InvoiceStatusDto>> getInvoiceStatus() {
        return ResponseEntity.status(HttpStatus.OK).body(invoiceStatusService.getInvoiceStatus());
    }

    @ApiOperation(value = "Get invoice status by ID")
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceStatusDto> getInvoiceStatusById(@PathVariable long id) {
        InvoiceStatusDto getInvoiceStatus = invoiceStatusService.getInvoiceStatusById(id);
        return ResponseEntity.status(HttpStatus.OK).body(invoiceStatusService.getInvoiceStatusById(id));
    }

    @ApiOperation(value = "Create invoice status")
    @PostMapping
    public ResponseEntity<InvoiceStatusDto> addInvoiceStatus(@Valid @RequestBody InvoiceStatusDto invoiceStatus) {
        InvoiceStatusDto saveInvoiceStatus = invoiceStatusService.addInvoiceStatus(invoiceStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveInvoiceStatus);
    }

    @ApiOperation(value = "Update invoice status")
    @PutMapping
    public ResponseEntity<InvoiceStatusDto> updateInvoiceStatus(@Valid @RequestBody InvoiceStatusDto invoiceStatus) {
        InvoiceStatusDto updateInvoiceStatus = invoiceStatusService.updateInvoiceStatus(invoiceStatus);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateInvoiceStatus);
    }

    @ApiOperation(value = "Delete invoice status by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoiceStatus(@PathVariable long id) {
        invoiceStatusService.deleteInvoiceStatus(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("InvoiceStatus with ID " + id + " was removed.");
    }

}
