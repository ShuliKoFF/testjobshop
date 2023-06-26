package ru.shrf.testjob.soap.wservices;

import ru.shrf.testjob.dto.*;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SaleWS {

    @WebMethod
    FinalPriceResponsDTO getFinalPrice(FinalPriceRequestDTO request);

    @WebMethod
    String registerSale(SaleRequestDTO request);

    @WebMethod
    StatisticResponseDTO getStatistic(ClientAndProductUUIDRequestDTO request);
}
