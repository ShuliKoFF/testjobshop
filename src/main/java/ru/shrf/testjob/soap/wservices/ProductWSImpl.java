package ru.shrf.testjob.soap.wservices;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.shrf.testjob.dto.ClientAndProductUUIDRequestDTO;
import ru.shrf.testjob.dto.ProductRatingRequestDTO;
import ru.shrf.testjob.dto.ProductResponsDTO;
import ru.shrf.testjob.dto.ProductInfoResponsDTO;
import ru.shrf.testjob.services.ProductService;
import ru.shrf.testjob.entity.Product;
import ru.shrf.testjob.exeption.Validator;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@WebService(endpointInterface = "ru.shrf.testjob.soap.wservices.ProductWS", serviceName = "ProductWS")
public class ProductWSImpl implements ProductWS {

    private final ProductService productService;

    @Override
    public List<ProductResponsDTO> getProducts() {
        List<Product> products = productService.getProducts();
        return products.stream()
                .map(productService::productToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductInfoResponsDTO getProductInfo(ClientAndProductUUIDRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkNotNull(request.getProductUUID(), "productUUID");
        return productService.getProductInfo(request.getClientUUID(), request.getProductUUID());
    }

    @Override
    public ProductInfoResponsDTO changeRating(ProductRatingRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkNotNull(request.getProductUUID(), "productUUID");
        if (request.getRating()!=null){
            Validator.checkNotNegative(BigDecimal.valueOf(request.getRating()), "rating");
        }
        return productService.changeProductRating(request.getClientUUID(), request.getProductUUID(), request.getRating());
    }
}
