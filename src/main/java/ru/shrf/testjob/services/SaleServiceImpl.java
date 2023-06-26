package ru.shrf.testjob.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shrf.testjob.dto.StatisticResponseDTO;
import ru.shrf.testjob.entity.Client;
import ru.shrf.testjob.entity.Position;
import ru.shrf.testjob.entity.Product;
import ru.shrf.testjob.entity.Sale;
import ru.shrf.testjob.exeption.BusinessExeptionCreater;
import ru.shrf.testjob.repository.ClientRepository;
import ru.shrf.testjob.repository.PositionRepository;
import ru.shrf.testjob.repository.ProductRepository;
import ru.shrf.testjob.repository.SaleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final PositionRepository positionRepository;
    private final ClientRepository clientRepository;

    @Value(value = "${saleService.discountMax}")
    private int discountMax;

    @Value(value = "${saleService.quantityForDiscountTwo}")
    private int quantityForDiscountTwo;

    @Value(value = "${saleService.checkNumberBase}")
    private int checkNumberBase;

    @Value(value = "${saleService.rangeCheckNumber}")
    private int rangeCheckNumber;

    @Override
    @Transactional(readOnly = true)
    public Long getFinalPrice(UUID clientUUID, Map<UUID, Integer> cart) {
        Client client = clientRepository.findByUUID(clientUUID)
                .orElseThrow(() ->
                        BusinessExeptionCreater.entityNotFound("Client", clientUUID)
                );
        return calculateFinalPrice(cart, client);
    }

    @Override
    @Transactional
    public String registerSale(UUID clientUUID, Map<UUID, Integer> cart, Long price) {
        Client client = clientRepository.findByUUID(clientUUID)
                .orElseThrow(() ->
                        BusinessExeptionCreater.entityNotFound("Client", clientUUID)
                );
        Long finalPriceSale = calculateFinalPrice(cart, client);
        if (finalPriceSale.compareTo(price) != 0) {
            log.warn("The entered price: [{}] is not equal to the calculated one: [{}]!", price, finalPriceSale);
            throw BusinessExeptionCreater.finalPriceNotValid();
        }

        List<Position> positions = createPositions(cart, client);
        Sale sale = saleRepository.save(new Sale(client.getId(), positions));
        positions.forEach(p -> p.setSale(sale));
        positionRepository.saveAll(positions);
        Integer checkNumber = sale.getCheckNumber();
        return String.format("%0" + rangeCheckNumber + "d", checkNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public StatisticResponseDTO getStatistic(UUID clientUUID, UUID productUUID) {
        if (isNull(clientUUID) && isNull(productUUID) ||
                !isNull(clientUUID) && !isNull(productUUID)) {
            throw BusinessExeptionCreater.requestStatisticNotValid();
        }

        if (!isNull(clientUUID)) {
            return getStatisticForClient(clientUUID);
        } else {
            return getStatisticForProduct(productUUID);
        }
    }

    boolean isNull(Object value) {
        return value == null;
    }

    @Override
    @Transactional
    public void resetCheckNumber() {
        saleRepository.resetCheckNumber(checkNumberBase);
    }

    @Override
    @Transactional
    public Integer compareNowWithLastDateSale(){
        LocalDate lastSale = saleRepository.findFirstByOrderByIdDesc().getDate().toLocalDate();
        LocalDate now = LocalDate.now();
        return now.compareTo(lastSale);
    }

    private Long calculateFinalPrice(Map<UUID, Integer> cart, Client client) {
        return cart.entrySet().stream()
                .map(pair -> {
                    Product product = productRepository.findByUUID(pair.getKey())
                            .orElseThrow(() ->
                                    BusinessExeptionCreater.entityNotFound("Product", pair.getKey())
                            );
                    int quantity = pair.getValue();
                    int finalDiscount = getFinalDiscount(quantity, client, product);
                    long priceForQuantity = product.getPrice() * quantity;
                    return getTotalPrice(finalDiscount, priceForQuantity);
                })
                .reduce(0L, Long::sum);
    }

    private List<Position> createPositions(Map<UUID, Integer> cart, Client client) {
        return cart.entrySet().stream()
                .map(pair -> {
                    Product product = productRepository.findByUUID(pair.getKey())
                            .orElseThrow(() -> BusinessExeptionCreater.entityNotFound("Product", pair.getKey())
                            );
                    int quantity = pair.getValue();
                    int finalDiscount = getFinalDiscount(quantity, client, product);
                    long priceForQuantity = product.getPrice() * quantity;
                    long finalPrice = getTotalPrice(finalDiscount, priceForQuantity);

                    return Position.builder()
                            .quantity(quantity)
                            .priceForQuantity(priceForQuantity)
                            .finalPrice(finalPrice)
                            .finalDiscount(finalDiscount)
                            .productId(product.getId())
                            .build();
                })
                .collect(Collectors.toList());
    }

    private int getFinalDiscount(int quantity, Client client, Product product) {
        int finalDiscount;
        int discountClient;
        if (quantity >= quantityForDiscountTwo)
            discountClient = client.getDiscountTwo();
        else
            discountClient = client.getDiscountOne();

        finalDiscount = discountClient + product.getDiscount();
        if (finalDiscount >= discountMax) finalDiscount = discountMax;
        return finalDiscount;
    }

    private Long getTotalPrice(int finalDiscount, Long priceForQuantity) {
        return (priceForQuantity) - ((priceForQuantity) * finalDiscount) / 100;
    }

    private StatisticResponseDTO getStatisticForClient(UUID clientUUID) {
        Client client = clientRepository.findByUUID(clientUUID)
                .orElseThrow(() ->
                        BusinessExeptionCreater.entityNotFound("Client", clientUUID)
                );

        List<Sale> sales = saleRepository.getAllSaleByClient(client.getId());
        Long priceForQuantitySum = sales.stream()
                .map(Sale::getPositions)
                .flatMap(positions -> positions.stream().map(Position::getPriceForQuantity))
                .reduce(0L, Long::sum);

        Long amountOnChecks = sales.stream()
                .map(Sale::getPositions)
                .flatMap(positions -> positions.stream().map(Position::getFinalPrice))
                .reduce(0L, Long::sum);

        return StatisticResponseDTO.builder()
                .quantityChecks(sales.size())
                .amountOnChecks(amountOnChecks)
                .amountDiscounts(priceForQuantitySum - amountOnChecks)
                .build();
    }

    private StatisticResponseDTO getStatisticForProduct(UUID productUUID) {
        Product product = productRepository.findByUUID(productUUID)
                .orElseThrow(() ->
                        BusinessExeptionCreater.entityNotFound("Product", productUUID)
                );
        List<Position> positions = positionRepository.getAllPositionByProduct(product.getId());
        Long priceForQuantitySum = positions.stream()
                .map(Position::getPriceForQuantity)
                .reduce(0L, Long::sum);

        Long amountOnChecks = positions.stream()
                .map(Position::getFinalPrice)
                .reduce(0L, Long::sum);

        return StatisticResponseDTO.builder()
                .quantityChecks(positions.size())
                .amountOnChecks(priceForQuantitySum)
                .amountDiscounts(priceForQuantitySum - amountOnChecks)
                .build();
    }
}
