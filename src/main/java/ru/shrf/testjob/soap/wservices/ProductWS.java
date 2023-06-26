package ru.shrf.testjob.soap.wservices;

import ru.shrf.testjob.dto.ClientAndProductUUIDRequestDTO;
import ru.shrf.testjob.dto.ProductInfoResponsDTO;
import ru.shrf.testjob.dto.ProductRatingRequestDTO;
import ru.shrf.testjob.dto.ProductResponsDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductWS {
    @WebMethod
    List<ProductResponsDTO> getProducts();

    @WebMethod
    ProductInfoResponsDTO getProductInfo(ClientAndProductUUIDRequestDTO request);

    @WebMethod
    ProductInfoResponsDTO changeRating(ProductRatingRequestDTO request);
}
