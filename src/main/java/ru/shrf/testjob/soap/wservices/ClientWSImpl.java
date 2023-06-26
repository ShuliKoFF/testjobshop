package ru.shrf.testjob.soap.wservices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.shrf.testjob.dto.ClientDiscountRequestDTO;
import ru.shrf.testjob.dto.ClientResponsDTO;
import ru.shrf.testjob.services.ClientService;
import ru.shrf.testjob.entity.Client;
import ru.shrf.testjob.exeption.Validator;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@WebService(endpointInterface = "ru.shrf.testjob.soap.wservices.ClientWS", serviceName = "ClientWS")
public class ClientWSImpl implements ClientWS {
    private final ClientService clientService;

    @Override
    public List<ClientResponsDTO> getClients() {
        List<Client> clients = clientService.getClients();
        return clients.stream()
                .map(clientService::clientToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponsDTO changeDiscountClient(ClientDiscountRequestDTO request) {
        Validator.checkNotNull(request.getUuid(), "uuid");
        Validator.checkNotNegative(BigDecimal.valueOf(request.getDiscountOne()), "discountOne");
        Validator.checkNotNegative(BigDecimal.valueOf(request.getDiscountTwo()), "discountTwo");

        Client client = clientService.changeDiscount(request.getUuid(), request.getDiscountOne(), request.getDiscountTwo());
        return clientService.clientToDto(client);
    }
}
