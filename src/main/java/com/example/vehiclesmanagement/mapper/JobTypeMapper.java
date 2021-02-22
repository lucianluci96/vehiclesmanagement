package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.JobTypeDto;
import com.example.vehiclesmanagement.entities.JobType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobTypeMapper {

    JobType mapToEntity(JobTypeDto jobTypeDto);

    JobTypeDto mapToDto(JobType jobType);
}
