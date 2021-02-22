package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;
    @NotNull(message = "Client Name is required")
    private String name;
    @NotNull(message = "Address is required")
    private String address;
    private String phone;
    @NotNull(message = "Mobile Phone is required")
    private String mobile;
    private String website;
    @NotNull(message = "Email is required")
    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    @Email
    private String email;
    @NotNull(message = "Country is required")
    private Long country_id;
    @NotNull(message = "City is required")
    private Long city_id;
    private String details;
}
