package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.EmployeeTypeDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.EmployeeTypeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employeetypes")
@AllArgsConstructor
public class EmployeeTypeController extends HandleValidationException {

    private final EmployeeTypeService employeeTypeService;

    @ApiOperation(value = "View a list with all available employee types")
    @GetMapping
    public ResponseEntity<List<EmployeeTypeDto>> getEmployeeTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.getEmployeeTypes());
    }

    @ApiOperation(value = "Get employee type by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeTypeDto> getEmployeeTypeById(@PathVariable long id) {
        EmployeeTypeDto getEmployeeType = employeeTypeService.getEmployeeTypeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeTypeService.getEmployeeTypeById(id));
    }

    @ApiOperation(value = "Create employee type")
    @PostMapping
    public ResponseEntity<EmployeeTypeDto> addEmployeeType(@Valid @RequestBody EmployeeTypeDto employeeType) {
        EmployeeTypeDto saveEmployeeType = employeeTypeService.addEmployeeType(employeeType);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployeeType);
    }

    @ApiOperation(value = "Update employee type")
    @PutMapping
    public ResponseEntity<EmployeeTypeDto> updateEmployeeType(@Valid @RequestBody EmployeeTypeDto employeeType) {
        EmployeeTypeDto updateEmployeeType = employeeTypeService.updateEmployeeType(employeeType);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateEmployeeType);
    }

    @ApiOperation(value = "Delete employee type by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeType(@PathVariable long id) {
        employeeTypeService.deleteEmployeeType(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("EmployeeType with ID " + id + " was removed.");
    }
}
