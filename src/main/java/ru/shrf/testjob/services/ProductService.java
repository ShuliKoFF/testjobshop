package ru.shrf.testjob.services;


import ru.shrf.testjob.dto.ProductResponsDTO;
import ru.shrf.testjob.dto.ProductInfoResponsDTO;
import ru.shrf.testjob.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getProducts();

    ProductInfoResponsDTO getProductInfo(UUID clientUUID, UUID productUUID);

    ProductInfoResponsDTO changeProductRating(UUID clientUUID, UUID productUUID, Integer rating);

    void updateDiscountInRangeRandom(int min, int max);

    ProductResponsDTO productToDTO(Product product);
}
