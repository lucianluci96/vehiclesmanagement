package com.example.vehiclesmanagement.controller;

import com.example.vehiclesmanagement.dto.ClientDto;
import com.example.vehiclesmanagement.exception.HandleValidationException;
import com.example.vehiclesmanagement.service.ClientService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController extends HandleValidationException {

    private final ClientService clientService;

    @ApiOperation(value = "View a list with all clients")
    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClients());
    }

    @ApiOperation(value = "Get client by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientById(id));
    }

    @ApiOperation(value = "Create client")
    @PostMapping
    public ResponseEntity<ClientDto> addClient(@Valid @RequestBody ClientDto client) {
        ClientDto saveClient = clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveClient);
    }

    @ApiOperation(value = "Update client")
    @PutMapping
    public ResponseEntity<ClientDto> updateClient(@Valid @RequestBody ClientDto client) {
        ClientDto updateClient = clientService.updateClient(client);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateClient);
    }

    @ApiOperation(value = "Delete client by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Client with ID " + id + " was removed.");
    }

}
