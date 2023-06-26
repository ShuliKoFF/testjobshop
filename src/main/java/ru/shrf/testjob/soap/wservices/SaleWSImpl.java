package ru.shrf.testjob.soap.wservices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.shrf.testjob.dto.*;
import ru.shrf.testjob.services.SaleService;
import ru.shrf.testjob.exeption.Validator;

import javax.jws.WebService;
import java.math.BigDecimal;


@Slf4j
@Service
@RequiredArgsConstructor
@WebService(endpointInterface = "ru.shrf.testjob.soap.wservices.SaleWS", serviceName = "SaleWS")
public class SaleWSImpl implements SaleWS {

    private final SaleService saleService;

    @Override
    public FinalPriceResponsDTO getFinalPrice(FinalPriceRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkMapCart(request.getCart(), "cart");
        Long finalPrice = saleService.getFinalPrice(request.getClientUUID(), request.getCart());
        return FinalPriceResponsDTO.builder().finalPrice(finalPrice).build();
    }

    @Override
    public String registerSale(SaleRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkMapCart(request.getCart(), "cart");
        Validator.checkNotNull(request.getPrice(), "price");
        Validator.checkNotNegative(BigDecimal.valueOf(request.getPrice()), "price");

        return saleService.registerSale(request.getClientUUID(), request.getCart(), request.getPrice());
    }

    @Override
    public StatisticResponseDTO getStatistic(ClientAndProductUUIDRequestDTO request) {
        return saleService.getStatistic(request.getClientUUID(), request.getProductUUID());
    }


}

