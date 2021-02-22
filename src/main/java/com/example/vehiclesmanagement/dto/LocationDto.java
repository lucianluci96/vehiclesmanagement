package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private Long id;
    private String description;
    private String details;
    @NotNull(message = "Country is required")
    private Long country_id;
    @NotNull(message = "City is required")
    private Long city_id;
    @NotNull(message = "Address is required")
    private String address;
}
