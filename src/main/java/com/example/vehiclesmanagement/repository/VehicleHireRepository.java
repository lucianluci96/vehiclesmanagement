package com.example.vehiclesmanagement.repository;

import com.example.vehiclesmanagement.entities.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Long> {

}
