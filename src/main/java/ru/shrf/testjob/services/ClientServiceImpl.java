package ru.shrf.testjob.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shrf.testjob.dto.ClientResponsDTO;
import ru.shrf.testjob.entity.Client;
import ru.shrf.testjob.exeption.BusinessExeptionCreater;
import ru.shrf.testjob.repository.ClientRepository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client changeDiscount(UUID clientUUID, Integer discountOne, Integer discountTwo) {
        Client client = clientRepository.findByUUID(clientUUID)
                .orElseThrow(() -> BusinessExeptionCreater.entityNotFound("Client", clientUUID)
                );
        client.setDiscountOne(discountOne);
        client.setDiscountTwo(discountTwo);
       return clientRepository.save(client);
    }

    @Override
    public ClientResponsDTO clientToDto(Client client) {
        return ClientResponsDTO.builder()
                .uuid(client.getUuid())
                .name(client.getName())
                .discountOne(client.getDiscountOne())
                .discountTwo(client.getDiscountTwo())
                .build();
    }
}
