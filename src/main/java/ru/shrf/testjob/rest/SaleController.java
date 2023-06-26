package ru.shrf.testjob.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shrf.testjob.dto.*;
import ru.shrf.testjob.exeption.Validator;
import ru.shrf.testjob.services.SaleService;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("rest/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @PostMapping("/final_price")
    public FinalPriceResponsDTO getFinalPrice(@RequestBody FinalPriceRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkMapCart(request.getCart(), "cart");
        Long finalPrice = saleService.getFinalPrice(request.getClientUUID(), request.getCart());
        return FinalPriceResponsDTO.builder().finalPrice(finalPrice).build();
    }

    @PostMapping("/registration")
    public String registerSale(@RequestBody SaleRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkMapCart(request.getCart(), "cart");
        Validator.checkNotNull(request.getPrice(), "price");
        Validator.checkNotNegative(BigDecimal.valueOf(request.getPrice()), "price");

        return saleService.registerSale(request.getClientUUID(), request.getCart(), request.getPrice());
    }

    @PostMapping("/statistic")
    public StatisticResponseDTO getStatistic(@RequestBody ClientAndProductUUIDRequestDTO request) {
        return saleService.getStatistic(request.getClientUUID(), request.getProductUUID());
    }
}