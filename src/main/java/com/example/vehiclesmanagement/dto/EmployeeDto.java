package com.example.vehiclesmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    @NotNull(message = "First Name is required")
    private String firstname;
    @NotNull(message = "Last Name is required")
    private String lastname;
    private String othername;
    private String title;
    private String initials;
    @NotNull(message = "Social Security Number is required")
    private String socialSecurityNumber;
    @NotNull(message = "Gender is required")
    private String gender;
    private String maritalStatus;
    @NotNull(message = "Country is required")
    private Long country_id;
    @NotNull(message = "City is required")
    private Long city_id;
    @NotNull(message = "Date of Birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @NotNull(message = "Address is required")
    private String address;
    private String phone;
    @NotNull(message = "Mobile Phone is required")
    private String mobile;
    @NotNull(message = "Email is required")
    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    @Email
    private String email;
    private String photo;
    @NotNull(message = "Employee Type is required")
    private Long employee_type_id;
    @NotNull(message = "Username is required")
    private String username;
    @NotNull(message = "Job Type is required")
    private Long job_type_id;
    @NotNull(message = "Hire Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;

}
