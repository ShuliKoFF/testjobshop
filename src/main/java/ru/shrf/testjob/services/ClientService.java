package ru.shrf.testjob.services;


import ru.shrf.testjob.dto.ClientResponsDTO;
import ru.shrf.testjob.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<Client> getClients();

    Client changeDiscount(UUID clientUUID, Integer discountOne, Integer discountTwo);

    ClientResponsDTO clientToDto(Client client);

}
