package com.example.vehiclesmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "vehicle_type_id", insertable = false, updatable = false)
    private VehicleType vehicleType;
    private Long vehicle_type_id;
    private String vehicleNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date acquisitionDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "vehicle_make_id", insertable = false, updatable = false)
    private VehicleMake vehicleMake;
    private Long vehicle_make_id;
    private String power;
    private String fuelCapacity;
    @ManyToOne
    @JoinColumn(name = "vehicle_status_id", insertable = false, updatable = false)
    private VehicleStatus vehicleStatus;
    private Long vehicle_status_id;
    private String netWeight;
    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee inCharge;
    private Long employee_id;
    @ManyToOne
    @JoinColumn(name = "vehicle_model_id", insertable = false, updatable = false)
    private VehicleModel vehicleModel;
    private Long vehicle_model_id;
    @ManyToOne
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private Location currentLocation;
    private Long location_id;
    private String remarks;
}
