package ru.shrf.testjob.soap.wservices;

import ru.shrf.testjob.dto.ClientResponsDTO;
import ru.shrf.testjob.dto.ClientDiscountRequestDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ClientWS {

    @WebMethod
    List<ClientResponsDTO> getClients();

    @WebMethod
    ClientResponsDTO changeDiscountClient(ClientDiscountRequestDTO request);
}
