package ru.shrf.testjob.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shrf.testjob.dto.ProductInfoResponsDTO;
import ru.shrf.testjob.dto.ProductResponsDTO;
import ru.shrf.testjob.entity.Client;
import ru.shrf.testjob.entity.Product;
import ru.shrf.testjob.entity.ProductRating;
import ru.shrf.testjob.exeption.BusinessExeptionCreater;
import ru.shrf.testjob.repository.ClientRepository;
import ru.shrf.testjob.repository.PositionRepository;
import ru.shrf.testjob.repository.ProductRatingRepository;
import ru.shrf.testjob.repository.ProductRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PositionRepository positionRepository;
    private final ClientRepository clientRepository;
    private final ProductRatingRepository productRatingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductInfoResponsDTO getProductInfo(UUID clientUUID, UUID productUUID) {
        Client client = clientRepository.findByUUID(clientUUID)
                .orElseThrow(() ->
                                BusinessExeptionCreater.entityNotFound("Client", clientUUID)
                );
        Product product = productRepository.findByUUID(productUUID)
                .orElseThrow(() ->
                                BusinessExeptionCreater.entityNotFound("Product", productUUID)
                );
        return getProductInfo(client, product);
    }

    private ProductInfoResponsDTO getProductInfo(Client client, Product product){
        List<ProductRating> ratings = productRatingRepository.findAllByProductId(product.getId());

        Map<Integer, Long> distributionOfRating = getDistributionOfRating(ratings);

        BigDecimal averageRating;
        final int[] currentRating = new int[1];
        currentRating[0] = 0;
        if (ratings.isEmpty()) {
            averageRating = BigDecimal.ZERO;
        } else {
            averageRating = getAverageRating(ratings);
            ratings.stream()
                    .filter(r -> r.getClientId().equals(client.getId()))
                    .findFirst().ifPresent(r -> currentRating[0] = r.getRating());
        }
        return ProductInfoResponsDTO.builder()
                .description(product.getDescription())
                .averageRating(averageRating)
                .distributionOfRating(distributionOfRating)
                .currentRating(currentRating[0])
                .build();
    }

    @Override
    @Transactional
    public ProductInfoResponsDTO changeProductRating(UUID clientUUID, UUID productUUID, Integer rating) {
        if ((rating != null && rating < 1) || (rating != null && rating > RatingEnum.values().length)) {
            throw BusinessExeptionCreater.ratingNotValid(rating);
        }
        Client client = clientRepository.findByUUID(clientUUID)
                .orElseThrow(() ->
                                BusinessExeptionCreater.entityNotFound("Client", clientUUID)
                );
        Product product = productRepository.findByUUID(productUUID)
                .orElseThrow(() ->
                                BusinessExeptionCreater.entityNotFound("Product", productUUID)
                );

        Long clientId = client.getId();
        Long productId = product.getId();

        if (isBuy(clientId, productId)) {
            Optional<ProductRating> ratingFromDB = productRatingRepository.findByClientAndProduct(clientId, productId);
            if (ratingFromDB.isPresent()) {
                updateRating(rating, ratingFromDB.get());
            } else {
                saveNewRating(rating, clientId, product);
            }
        } else {
            log.debug("Customer with id:[{}] didn't buy product with id:[{}]", clientId, productId);
            throw BusinessExeptionCreater.productNotBuy(clientUUID, productUUID);
        }
        return getProductInfo(client, product);
    }

    @Override
    @Transactional
    public void updateDiscountInRangeRandom(int min, int max) {
        List<Product> products = productRepository.findAll();
        Product product = products.get(random(0, products.size() - 1));
        product.setDiscount(random(min, max));
        productRepository.save(product);
        log.info("Product name: {}, ID: {}. Replacing the discount by {}", product.getName(), product.getId(), product.getDiscount());
    }

    @Override
    public ProductResponsDTO productToDTO(Product product) {
        return ProductResponsDTO.builder()
                .uuid(product.getUuid())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    private int random(int from, int to) {
        return (int) (from + (to - from) * Math.random());
    }

    private boolean isBuy(Long clientId, Long productId) {
        return !positionRepository.getAllByClientAndProduct(clientId, productId).isEmpty();
    }

    private void updateRating(Integer rating, ProductRating ratingFromDB) {
        if (rating == null) {
            productRatingRepository.delete(ratingFromDB);
        } else {
            ratingFromDB.setRating(rating);
            productRatingRepository.save(ratingFromDB);
        }
    }

    private void saveNewRating(Integer rating, Long clientId, Product product) {
        ProductRating productRating = ProductRating.builder()
                .rating(rating)
                .clientId(clientId)
                .product(product)
                .build();
        productRatingRepository.save(productRating);
    }

    private BigDecimal getAverageRating(List<ProductRating> ratings) {
        long sum = ratings.stream()
                .map(ProductRating::getRating)
                .mapToInt(i -> i)
                .sum();
        BigDecimal res = BigDecimal.valueOf(sum);
        BigDecimal div = BigDecimal.valueOf(ratings.size());
        return res.divide(div, 1, RoundingMode.DOWN);

    }

    private Long getCountOfRatings(List<ProductRating> ratings, RatingEnum ratingEnum) {
        Predicate<ProductRating> filter = rating -> (rating.getRating().equals(ratingEnum.getValue()));
        return ratings.stream()
                .filter(filter)
                .count();
    }

    private Map<Integer, Long> getDistributionOfRating(List<ProductRating> ratings) {
        return stream(RatingEnum.values())
                .collect(Collectors.toMap(RatingEnum::getValue,
                        v -> getCountOfRatings(ratings, v)
                        )
                );
    }

}

