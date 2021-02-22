package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.JobTypeDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.JobTypeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobtypes")
@AllArgsConstructor
public class JobTypeController extends HandleValidationException {

    private final JobTypeService jobTypeService;

    @ApiOperation(value = "View a list with all available job types")
    @GetMapping
    public ResponseEntity<List<JobTypeDto>> getVehiclesStatus() {
        return ResponseEntity.status(HttpStatus.OK).body(jobTypeService.getJobTypes());
    }

    @ApiOperation(value = "Get job type by ID")
    @GetMapping("/{id}")
    public ResponseEntity<JobTypeDto> getJobTypeById(@PathVariable long id) {
        JobTypeDto getJobType = jobTypeService.getJobTypeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(jobTypeService.getJobTypeById(id));
    }

    @ApiOperation(value = "Create job type")
    @PostMapping
    public ResponseEntity<JobTypeDto> addJobType(@Valid @RequestBody JobTypeDto jobType) {
        JobTypeDto saveJobType = jobTypeService.addJobType(jobType);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveJobType);
    }

    @ApiOperation(value = "Update job type")
    @PutMapping
    public ResponseEntity<JobTypeDto> updateJobType(@Valid @RequestBody JobTypeDto jobType) {
        JobTypeDto updateJobType = jobTypeService.updateJobType(jobType);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateJobType);
    }

    @ApiOperation(value = "Delete job type by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobType(@PathVariable long id) {
        jobTypeService.deleteJobType(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("JobType with ID " + id + " was removed.");
    }
}
