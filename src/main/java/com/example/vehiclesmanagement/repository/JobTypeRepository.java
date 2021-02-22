package com.example.vehiclesmanagement.repository;

import com.example.vehiclesmanagement.entities.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Long> {
}
