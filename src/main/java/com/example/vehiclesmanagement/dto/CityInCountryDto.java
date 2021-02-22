package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInCountryDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String details;

}
