package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleStatusDto {

    private Long id;
    @NotNull(message = "Vehicle Status Name is required")
    private String name;
    private String description;
}
