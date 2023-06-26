package ru.shrf.testjob.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.shrf.testjob.dto.ClientAndProductUUIDRequestDTO;
import ru.shrf.testjob.dto.ProductInfoResponsDTO;
import ru.shrf.testjob.dto.ProductRatingRequestDTO;
import ru.shrf.testjob.dto.ProductResponsDTO;
import ru.shrf.testjob.services.ProductService;
import ru.shrf.testjob.entity.Product;
import ru.shrf.testjob.exeption.Validator;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("rest/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<ProductResponsDTO> getProducts() {
        List<Product> products = productService.getProducts();
        return products.stream()
                .map(productService::productToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/info")
    public ProductInfoResponsDTO getProductInfo(@RequestBody ClientAndProductUUIDRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkNotNull(request.getProductUUID(), "productUUID");
        return productService.getProductInfo(request.getClientUUID(), request.getProductUUID());
    }

    @PostMapping("/rating")
    public ProductInfoResponsDTO changeRating(@RequestBody ProductRatingRequestDTO request) {
        Validator.checkNotNull(request.getClientUUID(), "clientUUID");
        Validator.checkNotNull(request.getProductUUID(), "productUUID");
        if (request.getRating()!=null){
            Validator.checkNotNegative(BigDecimal.valueOf(request.getRating()), "rating");
        }
        return productService.changeProductRating(request.getClientUUID(), request.getProductUUID(), request.getRating());
    }
}
