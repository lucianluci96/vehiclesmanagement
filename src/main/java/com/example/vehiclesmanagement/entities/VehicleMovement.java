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
public class VehicleMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    private Vehicle vehicle;
    private Long vehicle_id;
    @ManyToOne
    @JoinColumn(name = "location_id1", insertable = false, updatable = false)
    private Location location1;
    private Long location_id1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date1;
    @ManyToOne
    @JoinColumn(name = "location_id2", insertable = false, updatable = false)
    private Location location2;
    private Long location_id2;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date2;
    private String remarks;
}