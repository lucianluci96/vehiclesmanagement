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
public class VehicleHireDto {

    private Long id;
    @NotNull(message = "Vehicle is required")
    private Long vehicle_id;
    @NotNull(message = "Date From is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;
    @NotNull(message = "Time From is required")
    private String timeOut;
    @NotNull(message = "Date To is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;
    @NotNull(message = "Time In is required")
    private String timeIn;
    @NotNull(message = "Client is required")
    private Long client_id;
    @NotNull(message = "Location is required")
    private Long location_id;
    @NotNull(message = "Price is required")
    private Double price;
    private String remarks;
}
