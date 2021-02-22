package com.example.vehiclesmanagement.service;

import com.example.vehiclesmanagement.dto.ClientDto;
import com.example.vehiclesmanagement.entities.Client;
import com.example.vehiclesmanagement.exception.NotFoundException;
import com.example.vehiclesmanagement.mapper.ClientMapper;
import com.example.vehiclesmanagement.repository.CityRepository;
import com.example.vehiclesmanagement.repository.ClientRepository;
import com.example.vehiclesmanagement.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ClientMapper clientMapper;

    public List<ClientDto> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public ClientDto getClientById(long id) {
        return clientMapper.mapToDto(getClient(id));
    }

    public ClientDto addClient(ClientDto client) {
        checkIfCountryExists(client.getCountry_id());
        checkIfCityExists(client.getCity_id());

        Client saveClient = clientRepository.save(clientMapper.mapToEntity(client));
        return clientMapper.mapToDto(saveClient);
    }

    public ClientDto updateClient(ClientDto client) {
        checkIfCountryExists(client.getCountry_id());
        checkIfCityExists(client.getCity_id());

        getClient(client.getId());

        Client updateClient = clientRepository.save(clientMapper.mapToEntity(client));

        return clientMapper.mapToDto(updateClient);
    }

    public void deleteClient(long id) {
        getClient(id);
        clientRepository.deleteById(id);

    }

    private Client getClient(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with ID " + id + " was not found."));
    }

    private void checkIfCountryExists(Long countryId) {
        countryRepository.findById(countryId).orElseThrow(() -> new NotFoundException("Country with ID " + countryId + " was not found."));
    }

    private void checkIfCityExists(Long cityId) {
        cityRepository.findById(cityId).orElseThrow(() -> new NotFoundException("City with ID " + cityId + " was not found."));
    }

}
