package com.example.vehiclesmanagement.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Employee extends Person {

    @ManyToOne
    @JoinColumn(name = "employee_type_id", insertable = false, updatable = false)
    private EmployeeType employeeType;
    private Long employee_type_id;
    private String photo;
    private String username;
    @ManyToOne
    @JoinColumn(name = "job_type_id", insertable = false, updatable = false)
    private JobType jobType;
    private Long job_type_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
}
