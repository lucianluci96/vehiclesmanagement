package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.InvoiceDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.InvoiceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class InvoiceController extends HandleValidationException {

    private final InvoiceService invoiceService;

    @ApiOperation(value = "View a list with all invoices")
    @GetMapping
    public ResponseEntity<List<InvoiceDto>> getInvoices() {
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.getInvoices());
    }

    @ApiOperation(value = "Get invoice by ID")
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@Valid @PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.getInvoiceById(id));
    }

    @ApiOperation(value = "Create invoice")
    @PostMapping
    public ResponseEntity<InvoiceDto> addInvoice(@Valid @RequestBody InvoiceDto invoice) {
        InvoiceDto saveInvoice = invoiceService.addInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveInvoice);
    }

    @ApiOperation(value = "Update invoice")
    @PutMapping
    public ResponseEntity<InvoiceDto> updateInvoice(@RequestBody InvoiceDto invoice) {
        InvoiceDto updateInvoice = invoiceService.updateInvoice(invoice);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateInvoice);
    }

    @ApiOperation(value = "Delete invoice by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Invoice with ID " + id + " was removed.");
    }

}
