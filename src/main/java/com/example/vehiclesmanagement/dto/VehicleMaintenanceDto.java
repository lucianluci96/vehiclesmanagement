package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleMaintenanceDto {

    private int id;
    @NotNull(message = "Vehicle is required")
    private Long vehicle_id;
    @NotNull(message = "Maintenance From is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @NotNull(message = "Maintenance To is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @NotNull(message = "Price is required")
    private Double price;
    @NotNull(message = "Supplier is required")
    private Long supplier_id;
    private String remarks;
}
