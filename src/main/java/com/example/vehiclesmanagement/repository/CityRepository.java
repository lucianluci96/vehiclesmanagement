package com.example.vehiclesmanagement.repository;

import com.example.vehiclesmanagement.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("from City where country_id=:country_id")
    List<City> getCitiesFromCountry(@Param("country_id") Long countryId);
}
