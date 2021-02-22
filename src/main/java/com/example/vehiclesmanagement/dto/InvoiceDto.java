package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private Long id;
    @NotNull(message = "Invoice Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;
    @NotNull(message = "Invoice Status is required")
    private Long invoice_status_id;
    @NotNull(message = "Client is required")
    private Long client_id;
    private String remarks;
}
