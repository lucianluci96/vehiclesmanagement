package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.JobTypeDto;
import com.example.vehiclesmanagement.entities.JobType;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.JobTypeMapper;
import com.example.vehiclesmanagement.repository.JobTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobTypeService {

    private final JobTypeRepository jobTypeRepository;
    private final JobTypeMapper jobTypeMapper;

    public List<JobTypeDto> getJobTypes() {
        return jobTypeRepository.findAll()
                .stream()
                .map(jobTypeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public JobTypeDto getJobTypeById(long id) {
        return jobTypeMapper.mapToDto(getJobType(id));
    }

    public JobTypeDto addJobType(JobTypeDto jobType) {
        descriptionIsNotCompleted(jobType);
        JobType saveJobType = jobTypeRepository.save(jobTypeMapper.mapToEntity(jobType));
        return jobTypeMapper.mapToDto(saveJobType);
    }

    public JobTypeDto updateJobType(JobTypeDto jobType) {
        descriptionIsNotCompleted(jobType);
        getJobType(jobType.getId());

        JobType updateJobType = jobTypeRepository.save(jobTypeMapper.mapToEntity(jobType));
        return jobTypeMapper.mapToDto(updateJobType);
    }

    public void deleteJobType(long id) {
        getJobType(id);
        jobTypeRepository.deleteById(id);

    }

    private JobType getJobType(long id) {
        return jobTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("JobType with ID " + id + " not found"));
    }

    private void descriptionIsNotCompleted(JobTypeDto jobType) {
        if (jobType.getDescription() == null) {
            jobType.setDescription(jobType.getName());
        }
    }
}
