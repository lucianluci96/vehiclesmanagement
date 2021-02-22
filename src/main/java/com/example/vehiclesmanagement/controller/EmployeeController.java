package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.EmployeeDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController extends HandleValidationException {

    private final EmployeeService employeeService;

    @ApiOperation(value = "View a list with all employees")
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployees());
    }

    @ApiOperation(value = "Get employee by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }

    @ApiOperation(value = "Create employee")
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employee) {
        EmployeeDto saveEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);
    }

    @ApiOperation(value = "Update employee")
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employee) {
        EmployeeDto updateEmployee = employeeService.updateEmployee(employee);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateEmployee);
    }

    @ApiOperation(value = "Delete employee by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Employee with ID " + id + " was removed.");
    }

}
