package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityDto {

    private Long id;
    @NotNull(message = "City Name is required")
    @Size(min = 3)
    private String name;
    @NotNull(message = "Country is required")
    private Long country_id;
    private String details;
}
