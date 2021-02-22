package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModelDto {

    private Long id;
    @NotNull(message = "Vehicle Model Name is required")
    private String name;
    private String description;
}
