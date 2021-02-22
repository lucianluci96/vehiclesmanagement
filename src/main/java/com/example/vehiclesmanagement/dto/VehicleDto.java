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
public class VehicleDto {

    private Long id;
    @NotNull(message = "Vehicle Name is required")
    private String name;
    @NotNull(message = "Vehicle Type is required")
    private Long vehicle_type_id;
    @NotNull(message = "Vehicle Number is required")
    private String vehicleNumber;
    @NotNull(message = "Registration Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;
    @NotNull(message = "Acquisition Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date acquisitionDate;
    private String description;
    @NotNull(message = "Vehicle Make is required")
    private Long vehicle_make_id;
    @NotNull(message = "Power is required")
    private String power;
    @NotNull(message = "Fuel Capacity is required")
    private String fuelCapacity;
    @NotNull(message = "Vehicle Status is required")
    private Long vehicle_status_id;
    private String netWeight;
    @NotNull(message = "Employee is required")
    private Long employee_id;
    @NotNull(message = "Vehicle Model is required")
    private Long vehicle_model_id;
    @NotNull(message = "Location is required")
    private Long location_id;
    private String remarks;
}
