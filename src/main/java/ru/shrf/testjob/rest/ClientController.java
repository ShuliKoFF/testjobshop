package ru.shrf.testjob.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.shrf.testjob.dto.ClientDiscountRequestDTO;
import ru.shrf.testjob.dto.ClientResponsDTO;
import ru.shrf.testjob.services.ClientService;
import ru.shrf.testjob.entity.Client;
import ru.shrf.testjob.exeption.Validator;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/client")
@Slf4j
@RequiredArgsConstructor

public class ClientController {
    private final ClientService clientService;

    @GetMapping("/all")
    public List<ClientResponsDTO> getClients() {
        List<Client> clients = clientService.getClients();
        return clients.stream()
                .map(clientService::clientToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/change_discount")
    public ClientResponsDTO changeDiscountClient(@RequestBody ClientDiscountRequestDTO request) {
        Validator.checkNotNull(request.getUuid(), "uuid");
        Validator.checkNotNegative(BigDecimal.valueOf(request.getDiscountOne()), "discountOne");
        Validator.checkNotNegative(BigDecimal.valueOf(request.getDiscountTwo()), "discountTwo");

        Client client = clientService.changeDiscount(request.getUuid(), request.getDiscountOne(), request.getDiscountTwo());
        return clientService.clientToDto(client);
    }
}
