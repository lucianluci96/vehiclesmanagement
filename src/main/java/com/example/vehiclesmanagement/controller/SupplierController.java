package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.SupplierDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.SupplierService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
public class SupplierController extends HandleValidationException {

    private final SupplierService supplierService;

    @ApiOperation(value = "View a list with all suppliers")
    @GetMapping
    public ResponseEntity<List<SupplierDto>> getSuppliers() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getSuppliers());
    }

    @ApiOperation(value = "Get supplier by ID")
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getSupplierById(id));
    }

    @ApiOperation(value = "Create supplier")
    @PostMapping
    public ResponseEntity<SupplierDto> addSupplier(@Valid @RequestBody SupplierDto supplier) {
        SupplierDto saveSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveSupplier);
    }

    @ApiOperation(value = "Update supplier")
    @PutMapping
    public ResponseEntity<SupplierDto> updateSupplier(@Valid @RequestBody SupplierDto supplier) {
        SupplierDto updateSupplier = supplierService.updateSupplier(supplier);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateSupplier);
    }

    @ApiOperation(value = "Delete supplier by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Supplier with ID " + id + " was removed.");
    }

}
