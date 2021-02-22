package com.example.vehiclesmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String mobile;
    private String website;
    private String email;
    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;
    private Long country_id;
    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;
    private Long city_id;
    private String details;
}
