package com.example.vehiclesmanagement.mapper;

import com.example.vehiclesmanagement.dto.ClientDto;
import com.example.vehiclesmanagement.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client mapToEntity(ClientDto clientDto);

    ClientDto mapToDto(Client client);
}
